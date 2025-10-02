package com.liang.springioc.beanprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
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
public class MyBeanProcessor1 implements MergedBeanDefinitionPostProcessor  {

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        //可以拿到合并处理后的BeanDefinition 就是RootBeanDefinition
        //然后进行处理

    }

    @Override
    public void resetBeanDefinition(String beanName) {
        MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
    }
}
