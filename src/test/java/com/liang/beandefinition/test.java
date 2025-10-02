package com.liang.beandefinition;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.asm.ClassReader;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.io.IOException;

/**
 * ClassName: test
 * Package: com.liang
 * Description:
 *
 * @Author liang
 * @Create 2025/6/18 15:31
 * @Version jdk17.0
 */
@Slf4j(topic = "c.test")
public class test {


    @Test
    public void test1(){
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClassName("com.liang.bean.User");
    }
    @Test
    public void test2(){
            // 1、创建一个beanDefinitionRegistry
            BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
            // 2、创建一个beanDefinitionReader
            BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(registry);
            // 3、加载xml中的beanDefinition
            beanDefinitionReader.loadBeanDefinitions("spring-bean.xml");
            log.info("加载了{}个beanDefinition",registry.getBeanDefinitionCount());
    }
    @Test
    public void testClassPathBeanDefinitionScanner() {
        // 1、创建一个beanDefinitionRegistry
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        // 2、创建一个beanDefinitionReader
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        // 3、扫描com.ydlclass.bean这个包下的bean
        scanner.scan("com.liang.bean");
        System.out.println(registry.getBeanDefinitionCount());
    }
    @Test
    public void testAsm() throws IOException {
        ClassReader classReader = new ClassReader("com.liang.beandefinition.bean.Dog");
        String className = classReader.getClassName();
        log.info(className);
        String superName = classReader.getSuperName();
        log.info(superName);
        String[] interfaces = classReader.getInterfaces();
        for (String interfaceName : interfaces) {
            log.info(interfaceName);
        }

    }
}
