package com.juliuszhu.ecommerce;

import com.juliuszhu.ecommerce.domain.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class EcommerceWebApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() throws SQLException {

    }

}
