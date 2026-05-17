package com.example.yuyinriji.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 1. 静态资源映射（100%兼容Windows/Linux，彻底解决路径问题）
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 使用绝对路径，和 DiaryController 保存文件时保持一致
        String audioPath = new File(System.getProperty("user.dir"), "audio").toURI().toString();
        System.out.println("[WebConfig] 音频资源路径: " + audioPath);
        registry.addResourceHandler("/audio/**")
                .addResourceLocations(audioPath)
                .setCachePeriod(0); // 开发环境禁用缓存，避免旧文件干扰
    }

    // 2. 全局跨域配置（彻底解决前端访问音频/接口跨域问题）
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}