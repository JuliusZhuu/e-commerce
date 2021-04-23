package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.MyUser;
import org.apache.ibatis.annotations.Select;

/**
 * date 2021/4/23
 * time 18:04
 * author julius.zhu
 * describe:
 */
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    MyUser getUserInfo(String username);

    @Select("select * from user where username=#{username} and password=#{password}")
    MyUser getUserInfo(String username, String password);
}
