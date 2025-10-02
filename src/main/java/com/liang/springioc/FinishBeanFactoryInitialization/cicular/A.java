package com.liang.springioc.FinishBeanFactoryInitialization.cicular;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * ClassName: A
 * Package: com.liang.springioc.FinishBeanFactoryInitialization.cicular
 * Description:
 *
 * @Author liang
 * @Create 2025/6/30 20:18
 * @Version jdk17.0
 */
@Component
public class A {
    private  B b;
    @Autowired
    public void setB(B b){
        this.b = b;
    }

    public B getB(){
        return b;
    }

    public A( B b){
        this.b = b;
    }
    public A(){
        System.out.println("A()");
    }


}
