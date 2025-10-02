package com.liang.springboot.initialize;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class CustomApplicationListener implements SpringApplicationRunListener {

    private final SpringApplication application;
    private final String[] args;

    // 必须提供此构造函数，Spring Boot 通过反射调用
    public CustomApplicationListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("自定义监听器：应用启动开始");
        // 可以在这里添加自定义逻辑，例如初始化一些资源
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, 
                                   ConfigurableEnvironment environment) {
        System.out.println("自定义监听器：环境准备完成");
        // 可以访问和修改环境配置
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("自定义监听器：应用上下文准备完成");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("自定义监听器：应用上下文加载完成");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("自定义监听器：应用启动失败");
        if (exception != null) {
            exception.printStackTrace();
        }
    }
}