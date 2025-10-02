package com.liang.springioc.beanprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.*;
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
@Component
public class MyBeanProcessor2 implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanProcessor2");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanProcessor2");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
