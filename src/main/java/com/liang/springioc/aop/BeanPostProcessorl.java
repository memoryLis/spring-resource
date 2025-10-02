package com.liang.springioc.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ClassName: BeanPostProcessor
 * Package: com.liang.springioc.aop
 * Description:
 *
 * @Author liang
 * @Create 2025/9/8 20:24
 * @Version jdk17.0
 */
@Component
public class BeanPostProcessorl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessorlbefore");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessorlafter");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
