package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * time  21:35
 *
 * @author:julius.zhu
 * @describe:用户实体
 */
@Setter
@Getter
public class User extends BaseEntity {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatar="https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3140403455,2984550794&fm=26&gp=0.jpg";
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 令牌
     */
    private String token;

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
