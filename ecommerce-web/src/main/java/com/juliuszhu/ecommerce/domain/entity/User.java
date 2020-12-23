package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * time  21:35
 *
 * @author:julius.zhu describe:
 */
@Setter
@Getter
public class User {
    private Integer id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
