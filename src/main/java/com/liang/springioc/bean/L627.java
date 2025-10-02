package com.liang.springioc.bean;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * ClassName: L627
 * Package: com.liang.springioc.bean
 * Description:
 *
 * @Author liang
 * @Create 2025/6/27 15:54
 * @Version jdk17.0
 */
@Component
public class L627 implements Lifecycle {
    String name ;
    int age;
    public void print() {
        System.out.println("L627");
    }

    @Override
    public void start() {
        System.out.println("L627 start");
    }

    @Override
    public void stop() {
        System.out.println("L627 stop");

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
