package com.liang.tool.Introspector;
import com.liang.tool.bean.Brid;
import com.liang.tool.bean.Dogl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import java.beans.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
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
public class test {
    // 通过内省api获取BeanDescriptor Introspector 内省
    @Test
     public void testIntrospector() throws IntrospectionException {
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

    private HashMap<Integer, List<String>> myMap;
    public void testResolvableType() throws NoSuchFieldException {
        Field declaredField = getClass().getDeclaredField("myMap");
        ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("myMap"));
        t.getSuperType(); // AbstractMap<Integer, List<String>>
        t.asMap(); // Map<Integer, List<String>>
        t.getGeneric(0).resolve(); // Integer  // 获取泛型
        t.getGeneric(1).resolve(); // List
        t.getGeneric(1); // List<String>
        //第二个泛型,里面的泛型,即List<String>里面的String
        t.resolveGeneric(1, 0); // String
    }
    @Test
    public void regisBean() throws IntrospectionException, ClassNotFoundException {
        // 1、创建一个beanDefinitionRegistry
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        // 2、创建一个beanDefinitionReader
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(registry);
        // 3、加载xml中的beanDefinition
        beanDefinitionReader.loadBeanDefinitions("spring-bean.xml");
       // 4获得bean信息
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();//获取类的全限定名
            log.info("beanClassName -> {}", beanClassName);
            Class<?> aClass = Class.forName(beanClassName);
            BeanWrapper beanWrapper = new BeanWrapperImpl(aClass);
            GenericConversionService genericConversionService = new GenericConversionService();
            genericConversionService.addConverter(new Converter<TypedStringValue, Integer>(){
                @Override
                public Integer convert(TypedStringValue source) {
                    return Integer.parseInt(source.getValue());
                }
            });
            genericConversionService.addConverter(new Converter<TypedStringValue, String>(){
                @Override
                public String convert(TypedStringValue source) {
                    return source.getValue();
                }
            });
            beanWrapper.setConversionService(genericConversionService);

            beanWrapper.setPropertyValues(beanDefinition.getPropertyValues());
            Object wrappedInstance = beanWrapper.getWrappedInstance();
            log.info("wrappedInstance -> {}", wrappedInstance);



        }


    }
    HashMap<Integer, List<String>> myMap1;

    @Test
    public void test5(){
        try {

            ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("myMap1"));
            t.getSuperType(); // AbstractMap<Integer, List<String>>
            t.asMap(); // Map<Integer, List<String>>
            t.getGeneric(0).resolve(); // Integer  // 获取泛型
            t.getGeneric(1).resolve(); // List
            t.getGeneric(1); // List<String>
            //第二个泛型,里面的泛型,即List<String>里面的String
            t.resolveGeneric(1, 0); // String

        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }

    }
    
}
