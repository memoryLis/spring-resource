package com.liang.springmvc;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: MvcCif
 * Package: com.liang.springmvc
 * Description:
 *
 * @Author liang
 * @Create 2025/7/4 9:41
 * @Version jdk17.0
 */
public class MvcCig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
