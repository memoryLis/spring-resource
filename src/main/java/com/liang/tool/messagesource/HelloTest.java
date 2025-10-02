package com.liang.tool.messagesource;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * 演示如何使用MessageSource和参数
 */
public class HelloTest {

    /**
     * 演示国际化消息中参数的使用方式
     */
    public static void main(String[] args) {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/message");
        messageSource.setDefaultEncoding("UTF-8");
        
        // 这里的"hello"和"liang"作为参数传递给消息模板
        // 在修改后的资源文件中，{0}会被"hello"替换，{1}会被"liang"替换
        String chineseMsg = messageSource.getMessage("name", new Object[]{"hello", "liang"}, Locale.CHINA);
        String englishMsg = messageSource.getMessage("name", new Object[]{"hello", "liang"}, Locale.US);
        
        System.out.println("中文消息: " + chineseMsg);
        System.out.println("English message: " + englishMsg);
    }
}