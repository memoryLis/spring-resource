package com.liang.tool.messagesource;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * ClassName: Test
 * Package: com.liang.tool.messagesource
 * Description:
 *
 * @Author liang
 * @Create 2025/6/26 15:41
 * @Version jdk17.0
 */
public class Test {

    /**
     * spring引入了MessageSource机制，可以帮我们简单的实现国际化（ internationalization），
     * 简称i18n。ResourceBundleMessageSource是一个简单的实现，
     */
    @org.junit.Test
    public void internationalization(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/message");
        messageSource.setDefaultEncoding("UTF-8");
        System.out.println(messageSource.getMessage("name", new Object[]{"hello","liang"}, Locale.CHINA));
        System.out.println(messageSource.getMessage("name", new Object[]{"hello","liang"},  Locale.US));

    }
}
