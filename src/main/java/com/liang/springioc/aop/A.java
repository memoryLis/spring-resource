package com.liang.springioc.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

/**
 * ClassName: A
 * Package: com.liang.springioc.aop
 * Description:
 *
 * @Author liang
 * @Create 2025/9/7 20:13
 * @Version jdk17.0
 */
@Component
public class A {
    @Autowired
    public B b;

    public void print()
    {
        System.out.println("a");
    }
}
