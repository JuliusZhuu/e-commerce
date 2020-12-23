package com.juliuszhu.ecommerce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.juliuszhu.ecommerce.domain.mapper")
public class EcommerceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceWebApplication.class, args);
    }

}
