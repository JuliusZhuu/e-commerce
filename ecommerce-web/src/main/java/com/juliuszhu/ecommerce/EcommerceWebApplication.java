package com.juliuszhu.ecommerce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableCaching//开启缓存
@MapperScan("com.juliuszhu.ecommerce.domain.mapper")
public class EcommerceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceWebApplication.class, args);
    }

}
