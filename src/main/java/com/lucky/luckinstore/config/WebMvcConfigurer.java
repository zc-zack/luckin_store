package com.lucky.luckinstore.config;

import com.lucky.luckinstore.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: 张成
 * @date: Create in 2019/10/8
 * @description: 拦截器配置
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/**")
               .excludePathPatterns("/login")
               .excludePathPatterns("/user/home")
               .excludePathPatterns("/user/detail")
               .excludePathPatterns("/css/**")
               .excludePathPatterns("/img/**")
               .excludePathPatterns("/webjars/**")
               .excludePathPatterns("/checkPassword")
               .excludePathPatterns("/register")
               .excludePathPatterns("/checkUsername")
               .excludePathPatterns("/addUser")
               .excludePathPatterns("/logOut");
    }

}
