package com.liang.tool.enviroment;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * ClassName: EnviromentTest
 * Package: com.liang.tool.enviroment
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 17:09
 * @Version jdk17.0
 */
@Slf4j
public class EnvironmentTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-bean.xml");
        Environment environment = ctx.getEnvironment();
    }
    @Test
    public void testSystemProperties() {
        // jvm的信息
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            log.info("{} - {}", entry.getKey(), entry.getValue());
        }
    }
    @Test
    public void testSystemEnv() {
        Map<String, String> env = System.getenv();
        Set<Map.Entry<String, String>> entries = env.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            log.info("{} - {}", entry.getKey(), entry.getValue());
        }
    }


    /**
     * 自己定义键值对，放入环境中
     */
    @Test
    public void testCreateEnv(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-bean.xml");
        StandardEnvironment environment = (StandardEnvironment)ctx.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Properties properties = new Properties();
        properties.setProperty("nameliang","HGliang");
         propertySources.addFirst(new PropertiesPropertySource("myProperties", properties));
         log.info("{}",environment.getProperty("nameliang"));
    }
    @Test
    public void testCreateEnv1(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.liang");
        StandardEnvironment environment = (StandardEnvironment)ctx.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Properties properties = new Properties();
        properties.setProperty("nameliang","HGliang");
        propertySources.addFirst(new PropertiesPropertySource("myProperties", properties));
        log.info("{}",environment.getProperty("nameliang"));
        log.info("{}",environment.getProperty("my--name"));
    }

}
