package com.liang.springioc.bean;

import org.springframework.context.SmartLifecycle;
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
public class L628SmartLifecycle implements SmartLifecycle {
    /*
 当bean已经初始化完成，并且可以开始运行时，
 会调用这个接口start方法，当容器进行关闭时，调用这个接口的stop方法
 SmartLifecycle 接口的作用
SmartLifecycle 是 Spring 提供的一个扩展接口，用于更精细地控制 Bean 的启动和关闭行为。
它继承自 Lifecycle 接口，并增加了一些额外的方法，使其更适合与 Spring 容器的生命周期管理集成
     */

    String name ;
    int age;
    public void print() {
        System.out.println("L627");
    }

    /**
     * 当容器启动并且 Bean 初始化完成后，会调用 start() 方法。
     * 在这个方法中，你可以执行一些初始化操作，比如启动后台线程、连接外部服务等
     */
    @Override
    public void start() {
        System.out.println("L627 start");
    }

    /**
     * 当容器关闭时，会调用 stop() 方法。
     * 在这里你可以执行一些清理工作，比如关闭资源、断开连接等
     */
    @Override
    public void stop() {
        System.out.println("L627 stop");

    }

    /**
     * 该方法用于判断当前 Bean 是否处于运行状态。返回值通常用于控制是否需要调用 stop() 方法。
     * 如果返回 true，表示 Bean 正在运行；如果返回 false，则表示 Bean 已经停止。
     * @return
     */
    @Override
    public boolean isRunning() {
        return false;
    }
}
