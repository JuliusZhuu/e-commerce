package com.juliuszhu.ecommerce;

import com.juliuszhu.ecommerce.util.UpdateImageUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class EcommerceWebApplicationTests {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void test() {
        String pwd = "123456";
        String encode = passwordEncoder.encode(pwd);
        System.out.println("encode = " + encode);
    }

    @Autowired
    UpdateImageUrl updateImageUrl;

    @Test
    void testA() {
        updateImageUrl.updateUrl("192.168.1.105", "192.168.1.123");
    }

    @Autowired
    DataSource dataSource;

    @Test
    void test2() throws SQLException {
        System.out.println("dataSource = " + dataSource.getConnection());
    }
}
