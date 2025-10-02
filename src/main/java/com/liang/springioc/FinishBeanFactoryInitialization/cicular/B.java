package com.liang.springioc.FinishBeanFactoryInitialization.cicular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: B
 * Package: com.liang.springioc.FinishBeanFactoryInitialization.cicular
 * Description:
 *
 * @Author liang
 * @Create 2025/6/30 20:18
 * @Version jdk17.0
 */
@Component
public class B {
    public A a;
    @Autowired
    public void setA(A a) {
        this.a = a;
    }
    public A getA() {
        return a;
    }

    public B(A a) {
        this.a = a;
    }
    public B() {
        System.out.println("B()");
    }
}
