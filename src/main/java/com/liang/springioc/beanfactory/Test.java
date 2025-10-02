package com.liang.springioc.beanfactory;

import com.liang.tool.bean.UserTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.metrics.StartupStep;

/**
 * ClassName: Test
 * Package: com.liang.springioc
 * Description:
 *
 * @Author liang
 * @Create 2025/6/26 21:08
 * @Version jdk17.0
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void test() throws ClassNotFoundException {
        // 1、创建一个beanfactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 2、创建一个beanDefinitionReader
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        // 3、加载xml中的beanDefinition  beanfactory实现了beanDefinitionRegistry
        beanDefinitionReader.loadBeanDefinitions("spring-bean.xml");
        //实例化bean   //可以自定义实例化策略，这里使用了策略设计模式
        // defaultListableBeanFactory.preInstantiateSingletons();
        // log.info("bean -> {}", defaultListableBeanFactory.getBean("userTool"));

        InstantiationStrategy cglibInstantiationStrategy = new CglibSubclassingInstantiationStrategy();
        String beanName = "userTool";
        BeanDefinition beanDefinition = defaultListableBeanFactory.getBeanDefinition(beanName);
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.overrideFrom(beanDefinition);
        rootBeanDefinition.setBeanClass(Class.forName(beanDefinition.getBeanClassName()));
        Object bean = cglibInstantiationStrategy.instantiate(rootBeanDefinition, beanName, defaultListableBeanFactory);
        log.info("bean -> {}", bean);



    }

    @org.junit.Test
    public void testBeanProcessor() throws ClassNotFoundException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        log.info("bean -> {}", applicationContext.getBean("userTool"));
    }

    @org.junit.Test
    public void testApplicationStartup()  {
        BufferingApplicationStartup startup = new BufferingApplicationStartup(32);
        StartupStep startupStep = startup.start("程序即将启动！");
        startupStep.tag("第一步", "xxxx");
        startupStep.tag("第二步", "xxxx");
        startupStep.end();

        StartupStep startupStep2 = startup.start("程序即将启动2！");
        startupStep2.tag("第一步2", "xxxx");
        startupStep2.tag("第二步2", "xxxx");
        startupStep2.end();
    }

    @org.junit.Test
    public void test1(){
        String a = "afdl";
        Object object = "afsdlkfa;s";
        if(object instanceof String A){
            System.out.println(A);

        }

    }
}
