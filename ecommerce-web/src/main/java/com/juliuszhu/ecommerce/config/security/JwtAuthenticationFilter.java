package com.juliuszhu.ecommerce.config.security;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juliuszhu.ecommerce.domain.entity.MyUser;
import com.juliuszhu.ecommerce.domain.entity.ResponseEntity;
import com.juliuszhu.ecommerce.service.UserService;
import com.juliuszhu.ecommerce.util.JwtUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 认证过滤器
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UserService userService;

    /*
    过滤器一定要设置 AuthenticationManager，所以此处我们这么编写，这里的 AuthenticationManager
    我会从 Security 配置的时候传入
    */
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                   UserService userService) {
        /*
        运行父类 UsernamePasswordAuthenticationFilter 的构造方法，能够设置此滤器指定
        方法为 POST [\login]
        */
        super();
        setAuthenticationManager(authenticationManager);
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String header = request.getHeader("content-type");
        //获取json请求的数据
        String username = null;
        String password = null;
        //判断请求类型,发送的是json数据
        Map<String, String> stringStringMap;
        String substring = null;
        if (header.contains(";")) {
            substring = header.substring(0, header.indexOf(";"));
        } else if (header.contains("/")) {
            substring = header.substring(0, header.indexOf("/"));
        }
        if (MediaType.APPLICATION_JSON_VALUE.equals(substring)) {
            stringStringMap = parseJsonRequest(request);
        } else {
            stringStringMap = parseFormRequest(request);
        }
        Set<Map.Entry<String, String>> entries = stringStringMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            if ("username".equals(key)) {
                username = entry.getValue();
            } else if ("password".equals(key)) {
                password = entry.getValue();
            }
        }
        // 从请求的 POST 中拿取 username 和 password 两个字段进行登入,表单提交
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        // 设置一些客户 IP 啥信息，后面想用的话可以用，虽然没啥用
        setDetails(request, token);
        // 交给 AuthenticationManager 进行鉴权
        return getAuthenticationManager().authenticate(token);
    }

    /**
     * 解析发送过来的是json格式的用户名和密码
     *
     * @param request 请求对象
     * @return 解析之后的用户名和密码
     */
    private Map<String, String> parseJsonRequest(HttpServletRequest request) {
        Map<String, String> usernameAndPassword = new HashMap<>();
        try {
            String s = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONObject.parseObject(s);
            usernameAndPassword.put("username", jsonObject.getString("username"));
            usernameAndPassword.put("password", jsonObject.getString("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usernameAndPassword;
    }

    /**
     * 解析表单提交的用户名和密码
     *
     * @param request 请求对象
     * @return
     */
    private Map<String, String> parseFormRequest(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, String> usernameAndPassword = new HashMap<>();
        usernameAndPassword.put("username", username);
        usernameAndPassword.put("password", password);
        return usernameAndPassword;
    }

    /*
    鉴权成功进行的操作，我们这里设置返回加密后的 token
    */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {
        handleResponse(request, response, authResult, null);
    }

    /*
    鉴权失败进行的操作，我们这里就返回 用户名或密码错误 的信息
    */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        handleResponse(request, response, null, failed);
    }

    private void handleResponse(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authResult,
                                AuthenticationException failed) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity responseEntity = new ResponseEntity();
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        if (authResult != null) {
            // 处理登入成功请求
            User user = (User) authResult.getPrincipal();
            String token = JwtUtil.sign(user.getUsername(), user.getPassword());
            responseEntity.setStatus(HttpStatus.OK.value());
            responseEntity.setMsg("登入成功");
            //查询下数据库中用户数据
            MyUser userInfo = userService.getUserInfo(user.getUsername());
            userInfo.setToken("Bearer " + token);
            responseEntity.setData(userInfo);
            response.setStatus(HttpStatus.OK.value());
            response.getWriter().write(mapper.writeValueAsString(responseEntity));
        } else {
            // 处理登入失败请求
            responseEntity.setStatus(HttpStatus.BAD_REQUEST.value());
            responseEntity.setMsg("用户名或密码错误");
            responseEntity.setData(null);
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write(mapper.writeValueAsString(responseEntity));
        }
    }
}
