package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.MyUser;
import java.util.Map;

/**
 * date: 2020/12/31
 * time: 17:01
 *
 * @author:julius.zhu
 * @describe:
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param user 用户信息对象
     * @return 携带token的用户信息
     */
    Map<String, Object> loginByWeb(MyUser user);

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return
     */
    MyUser getUserInfo(String username);

    /**
     * 根据用户名和密码获取用户信息
     *
     * @param username 用户名
     * @param password 用户密码
     * @return
     */
    MyUser getUserInfo(String username, String password);
}
