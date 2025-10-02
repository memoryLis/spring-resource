package com.liang.springioc.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: Test
 * Package: com.liang.springioc.aop
 * Description:
 *
 * @Author liang
 * @Create 2025/9/7 20:15
 * @Version jdk17.0
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx =new AnnotationConfigApplicationContext("com.liang.springioc.aop");
        A a = (A)ctx.getBean("a");
        B b = (B)ctx.getBean("b");
        a.print();
        b.print();

    }
}
