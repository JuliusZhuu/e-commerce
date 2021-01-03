package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.MyUser;
import com.juliuszhu.ecommerce.domain.mapper.UserMapper;
import com.juliuszhu.ecommerce.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * date: 2020/12/31
 * time: 17:01
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class UserServiceImp implements UserService {
    private final UserMapper userMapper;

    public UserServiceImp(UserMapper userMapper  ) {
        this.userMapper = userMapper;
    }

    @Override
    public Map<String, Object> loginByWeb(MyUser user) {
        return null;
    }

    @Override
    public MyUser getUserInfo(String username) {
        return userMapper.getUserInfo(username);
    }

    @Override
    public MyUser getUserInfo(String username, String password) {
        return userMapper.getUserInfo(username, password);
    }
}
