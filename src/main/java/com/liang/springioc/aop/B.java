package com.liang.springioc.aop;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: B
 * Package: com.liang.springioc.aop
 * Description:
 *
 * @Author liang
 * @Create 2025/9/7 20:14
 * @Version jdk17.0
 */
@Component
public class B {
    @Autowired
    private A a;

    @PostConstruct
    public void init()
    {
        System.out.println("b init postconstruct");
    }

    public void print()
    {
        System.out.println("b");
    }
}
