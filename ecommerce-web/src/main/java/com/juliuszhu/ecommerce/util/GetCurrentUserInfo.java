package com.juliuszhu.ecommerce.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * date: 2021/1/3
 * time: 20:21
 *
 * @author:julius.zhu
 * @describe: 获取当前登录用户的信息
 */
public class GetCurrentUserInfo {
    /**
     * 获取当前登录用户的用户名
     *
     * @return 用户名
     */
    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
