package com.juliuszhu.ecommerce.web;

import com.juliuszhu.ecommerce.domain.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * date: 2020/12/26
 * time: 10:01
 *
 * @author:julius.zhu
 * @describe:用户controller
 */
@RestController
@RequestMapping("auth")
public class UserController {

    /**
     * 用户登录
     *
     * @param user 用户信息对象
     * @return
     */
    @PostMapping("loginByWeb")
    public Map<String, Object> loginByWeb(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        if ("julius".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            //随机生成口令
            String token = UUID.randomUUID().toString();
            //随机昵称
            String nickName = "用户" + UUID.randomUUID().toString().substring(0, 8);
            user.setToken(token);
            user.setNickName(nickName);
            result.put("loginResult", "登录成功");
            result.put("user", user);
        } else {
            result.put("loginResult", "登录失败");
        }
        return result;
    }
}
