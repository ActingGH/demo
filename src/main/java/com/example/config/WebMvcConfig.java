package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 通过修改 WebMvc 配置设置为跨域 ，底层是通过 Interceptor 实现
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 处理请求的路径
                .allowCredentials(false) // 是否生成凭证
                .allowedHeaders("*") // 允许携带哪些请求头信息
                .allowedMethods("*") // 允许哪些方法
                .allowedOrigins("*") // 允许哪些域进行方法
                .exposedHeaders() // 响应哪些响应头信息
                .maxAge(3600); // 预检请求的时长

    }
}