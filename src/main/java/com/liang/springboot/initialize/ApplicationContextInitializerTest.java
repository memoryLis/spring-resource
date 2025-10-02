package com.liang.springboot.initialize;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ClassName: ApplicationContextInitializerTest
 * Package: com.liang.springboot.initialize
 * Description:
 *ApplicationContextInitializer
 * @Author liang
 * @Create 2025/7/5 10:11
 * @Version jdk17.0
 */
public class ApplicationContextInitializerTest implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
    }
}
