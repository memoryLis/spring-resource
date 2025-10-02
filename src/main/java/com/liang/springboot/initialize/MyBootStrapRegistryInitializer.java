package com.liang.springboot.initialize;

import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;

/**
 * ClassName: MyBootStrapRegistyInitalizer
 * Package: com.liang.springboot.bootstrap
 * Description:
 * @Author liang
 * @Create 2025/7/4 11:10
 * @Version jdk17.0
 */
public class MyBootStrapRegistryInitializer implements BootstrapRegistryInitializer {
    @Override
    public void initialize(BootstrapRegistry bootstrapRegistry) {
        // 初始化逻辑，可以注册自定义资源或配置、
        bootstrapRegistry.addCloseListener(event -> {
            System.out.println("关闭");
        });
    }
}


