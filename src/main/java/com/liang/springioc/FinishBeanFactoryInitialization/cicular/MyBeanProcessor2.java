package com.liang.springioc.FinishBeanFactoryInitialization.cicular;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyBeanProcessor
 * Package: com.liang.springioc.beanprocessor
 * Description:
 *
 * @Author liang
 * @Create 2025/6/27 14:51
 * @Version jdk17.0
 */
// @Component
public class MyBeanProcessor2 implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("b"))
        System.out.println("MyBeanProcessor2");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
         if(beanName.equals("b"))
        System.out.println("MyBeanProcessor2");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
