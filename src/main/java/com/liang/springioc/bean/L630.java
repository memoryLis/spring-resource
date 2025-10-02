package com.liang.springioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ClassName: L630
 * Package: com.liang.springioc.bean
 * Description:
 *
 * @Author liang
 * @Create 2025/6/30 16:00
 * @Version jdk17.0
 */
@Component
public class L630 implements BeanPostProcessor {

    private String l630;
    @Autowired
    private L629 l629;
    @Value("黄亮")
    private  String name ;


    /**
     * 在bean初始化之前执行
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 在bean初始化后执行
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
