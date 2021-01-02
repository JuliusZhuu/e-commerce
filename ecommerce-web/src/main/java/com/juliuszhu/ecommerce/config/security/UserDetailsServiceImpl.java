package com.juliuszhu.ecommerce.config.security;

import com.juliuszhu.ecommerce.domain.entity.MyUser;
import com.juliuszhu.ecommerce.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库中查询是否存在该用户
        MyUser userInfo = userService.getUserInfo(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("This username didn't exist.");
        }
        return new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getAuthorities());
    }
}
