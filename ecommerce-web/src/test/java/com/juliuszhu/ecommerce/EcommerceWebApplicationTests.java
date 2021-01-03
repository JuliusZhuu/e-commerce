package com.juliuszhu.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class EcommerceWebApplicationTests {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void test() {
        String pwd="123456";
        String encode = passwordEncoder.encode(pwd);
        System.out.println("encode = " + encode);
    }
}
