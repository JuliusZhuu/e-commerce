package com.juliuszhu.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * date: 2020/12/23
 * time: 21:49
 *
 * @author:julius.zhu
 * @describe: webMvc相关配置信息
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //对哪种格式的请求进行跨域处理,/**表示所有
        registry.addMapping("/**")
                .allowedOrigins("*")//表示支持任意请求的域
                .allowedMethods("*");//支持的请求方式
        //       .allowedOrigins("http://localhost:63342");//表示支持来自的域

    }
}
