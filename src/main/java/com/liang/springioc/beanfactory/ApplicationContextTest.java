package com.liang.springioc.beanfactory;

import com.liang.springioc.FinishBeanFactoryInitialization.MyFactoryBean;
import com.liang.springioc.bean.L627;
import com.liang.springioc.bean.L629;
import com.liang.springioc.bean.L630;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * ClassName: ApplicationContextTest
 * Package: com.liang.springioc.beanfactory
 * Description:
 *
 * @Author liang
 * @Create 2025/6/27 15:48
 * @Version jdk17.0
 */
public class ApplicationContextTest {
    @Test
    public void test() throws ClassNotFoundException {
        //spirng 3.0后推出
        ApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:spring-bean.xml");
        Object bean = applicationContext.getBean("userTool");
        System.out.println(bean);
    }
    @Test
    public void testAnnotationApplicationContext(){
     ApplicationContext   applicationContext=new AnnotationConfigApplicationContext(MyFactoryBean.class);

      Object myBean = applicationContext.getBean("myFactoryBean");
        Object myBeanFactory = applicationContext.getBean("&myFactoryBean");
        //加入&获取其工厂bean

        System.out.println(myBean);

    }

    @Test
    public void testAnnotationApplicationContext1(){
        ApplicationContext   applicationContext=new AnnotationConfigApplicationContext("com.liang.springioc.bean");
        L630 bean = applicationContext.getBean(L630.class);
        //加入&获取其工厂bean



    }
}
