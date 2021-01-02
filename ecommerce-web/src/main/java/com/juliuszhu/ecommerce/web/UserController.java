package com.juliuszhu.ecommerce.web;

import com.juliuszhu.ecommerce.domain.entity.MyUser;
import com.juliuszhu.ecommerce.service.UserService;
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
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     *
     * @param user 用户信息对象
     * @return
     */
    @PostMapping("loginByWeb")
    public Map<String, Object> loginByWeb(@RequestBody MyUser user) {
        return  userService.loginByWeb(user);
    }
}
