package com.liang.tool.enviroment;

import com.liang.tool.bean.Brid;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

/**
 * ClassName: ProfileTest
 * Package: com.liang.tool.enviroment
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 18:17
 * @Version jdk17.0
 */
@Slf4j
public class ProfileTest {
    public static void main(String[] args) {
        //创建上下文
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //配置环境
        ConfigurableEnvironment environment = ctx.getEnvironment();
        environment.setActiveProfiles("dev");
        ctx.setEnvironment( environment);
        //重新扫描
        ctx.scan("com.liang.tool.enviroment");
        ctx.refresh();
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("bean:{}",beanDefinitionName);
        }
        //配置bean
        Brid brid = ctx.getBean(Brid.class);
        log.info("brid:{}",brid);
        A a = ctx.getBean(A.class);


    }

}
