package com.liang.beandefinition;
import com.liang.tool.bean.Brid;
import com.liang.tool.bean.Dogl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;

import java.beans.*;
import java.util.Map;

/**
 * ClassName: test
 * Package: com.liang.tool.Introspector
 * Description:
 *
 * @Author liang
 * @Create 2025/6/19 14:56
 * @Version jdk17.0
 */
@Slf4j(topic = "l.test")
public class test2 {
    // 通过内省api获取BeanDescriptor Introspector 内省
    @Test
     public void test() throws IntrospectionException {
        // 1、通过内省api获取BeanDescriptor Introspector 内省
        //一般用于获取的是javabean  javabean:属性为private 属性有对应的getter和setter 有无参构造器
        BeanInfo beanInfo = Introspector.getBeanInfo(Brid.class);
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        log.info("beanDescriptor -> {}", beanDescriptor.getName());

        // 2、直接获取属性描述器中的读方法、写方法等
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            log.info("name -> {}", descriptor.getName());
            log.info("readMethod -> {}", descriptor.getReadMethod());
            log.info("writeMethod -> {}", descriptor.getWriteMethod());
            log.info("descriptorString -> {}", descriptor.getPropertyType().descriptorString());
        }

     }

    @Test
    public void testBeanWrapper() throws IntrospectionException {
        // 在构造的过程中就会实例化
        BeanWrapper beanWrapper = new BeanWrapperImpl(Dogl.class);
        // 通过beanWrapper设置属性
        beanWrapper.setPropertyValue("color", "red");
        log.info("bean -> {}", beanWrapper.getWrappedInstance());

        // 通过beanWrapper使用map批量设置属性
        Map<String, Object> map = Map.of("color", "black", "age", 10);
        beanWrapper.setPropertyValues(map);
        log.info("bean -> {}", beanWrapper.getWrappedInstance());

        // 通过beanWrapper使用MutablePropertyValues批量设置属性
        MutablePropertyValues pvs = new MutablePropertyValues();  // 是不是beanDefinition中的内容
        pvs.addPropertyValue("color","blue");
        pvs.addPropertyValue("age", 20);
        beanWrapper.setPropertyValues(pvs);
        log.info("bean -> {}", beanWrapper.getWrappedInstance());
    }
}
