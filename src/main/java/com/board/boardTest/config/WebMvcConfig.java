package com.board.boardTest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//    LoggerInterceptor 클래스가 작동할 수 있도록 클래스를 빈(Bean)으로 등록해 줌
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
                .excludePathPatterns("/css/**", "/images/**", "/js/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Integer cachePeriod = 60 * 60 * 24 * 365;
        registry.addResourceHandler(
                        "/images/**",
                        "/css/**",
                        "/js/**",
                        "/media/**",
                        "/plugins/**",
                        "/webfonts/**")
                .addResourceLocations("classpath:/static/css/")
                .addResourceLocations("classpath:/static/js/")
                .addResourceLocations("classpath:/static/images/")
                .addResourceLocations("classpath:/static/media/")
                .addResourceLocations("classpath:/static/plugins/")
                .addResourceLocations("classpath:/static/webfonts/");
    }

}