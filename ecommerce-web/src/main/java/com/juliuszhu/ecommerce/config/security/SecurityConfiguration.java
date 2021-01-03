package com.juliuszhu.ecommerce.config.security;

import com.juliuszhu.ecommerce.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.lang.reflect.Constructor;

// 开启 Security
@EnableWebSecurity
// 开启注解配置支持
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    // Spring Boot 的 CacheManager，这里我们使用 JCache
    private final CacheManager cacheManager;
    private final UserService userService;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsServiceImpl,
                                 CacheManager cacheManager, UserService userService) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.cacheManager = cacheManager;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启跨域
        http.cors()
                .and()
                .formLogin()
                .loginProcessingUrl("login")
                .and()
                // security 默认 csrf 是开启的,我们使用了token,这个也没有什么必要了
                .csrf().disable()
                .authorizeRequests()
                // 默认所有请求通过，但是我们要在需要权限的方法加上安全注解，这样比写死配置灵活很多
                .anyRequest().permitAll()
                .and()
                // 添加自己编写的两个过滤器
                .addFilter(new JwtAuthenticationFilter(authenticationManager(),userService))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), cachingUserDetailsService(userDetailsServiceImpl)))
                // 前后端分离是 STATELESS，故 session 使用该策略
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 处理跨域问题
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //  你需要跨域的地址  注意这里的 127.0.0.1 != localhost

        // * 表示对所有的地址都可以访问
        corsConfiguration.addAllowedOrigin("*");
        //表示只允许http://localhost:8080地址的访问（重点哦）
        //corsConfiguration.addAllowedOrigin("http://localhost:8080");
        //跨域的请求头
        corsConfiguration.addAllowedHeader("*");
        // 跨域的请求方法
        corsConfiguration.addAllowedMethod("*");
        //加上了这一句，大致意思是可以携带 cookie
        //最终的结果是可以 在跨域请求的时候获取同一个 session
        //corsConfiguration.setAllowCredentials(true);
        //配置可以访问的地址
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

    // 此处配置 AuthenticationManager，并且实现缓存
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 对自己编写的 UserDetailsServiceImpl 进一步包装，实现缓存
        CachingUserDetailsService cachingUserDetailsService = cachingUserDetailsService(userDetailsServiceImpl);
        // jwt-cache 我们在 ehcache.xml 配置文件中有声明
        UserCache userCache = new SpringCacheBasedUserCache(cacheManager.getCache("jwt-cache"));
        cachingUserDetailsService.setUserCache(userCache);
        /*
        security 默认鉴权完成后会把密码抹除，但是这里我们使用用户的密码来作为 JWT 的生成密钥，
        如果被抹除了，在对 JWT 进行签名的时候就拿不到用户密码了，故此处关闭了自动抹除密码。
         */
        auth.eraseCredentials(false);
        auth.userDetailsService(cachingUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
    此处我们实现缓存的时候，我们使用了官方现成的 CachingUserDetailsService ，但是这个类的构造方法不是 public 的，
    我们不能够正常实例化，所以在这里进行曲线救国。
     */
    private CachingUserDetailsService cachingUserDetailsService(UserDetailsServiceImpl delegate) {

        Constructor<CachingUserDetailsService> ctor = null;
        try {
            ctor = CachingUserDetailsService.class.getDeclaredConstructor(UserDetailsService.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Assert.notNull(ctor, "CachingUserDetailsService constructor is null");
        ctor.setAccessible(true);
        return BeanUtils.instantiateClass(ctor, delegate);
    }

}
