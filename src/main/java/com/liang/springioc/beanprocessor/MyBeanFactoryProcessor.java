package com.liang.springioc.beanprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;

/**
 * ClassName: MyBeanProcessor
 * Package: com.liang.springioc.beanprocessor
 * Description:
 *
 * @Author liang
 * @Create 2025/6/27 14:51
 * @Version jdk17.0
 */

public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    //会在beanfactory创建完成之后被调用
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userTool");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        Object value = propertyValues.getPropertyValue("name").getValue();

        String base64Value = ((TypedStringValue) value).getValue();
        String realName = Base64Example.decodeFromBase64(base64Value);
        propertyValues.addPropertyValue("name", realName);
    }
}
