package com.liang.springioc.FinishBeanFactoryInitialization.cicular;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * ClassName: MergeProcess
 * Package: com.liang.springioc.FinishBeanFactoryInitialization.cicular
 * Description:
 *
 * @Author liang
 * @Create 2025/7/1 9:27
 * @Version jdk17.0
 */
// @Component
public class MergeProcess implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        System.out.println("8888888888888888");

    }

    @Override
    public void resetBeanDefinition(String beanName) {
        MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
    }
}
