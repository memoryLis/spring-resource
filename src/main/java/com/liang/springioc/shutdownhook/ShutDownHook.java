package com.liang.springioc.shutdownhook;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * ClassName: ShutDownHook
 * Package: com.liang.springioc.shutdownhook
 * Description:
 *
 * @Author liang
 * @Create 2025/6/28 17:12
 * @Version jdk17.0
 */
public class ShutDownHook {
    @Test
    public void test() throws ClassNotFoundException {
        //spirng 3.0后推出
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:spring-bean.xml");
        Object bean = applicationContext.getBean("userTool");
        System.out.println(bean);
        applicationContext.registerShutdownHook();//是 Spring 框架中用于注册关闭钩子（Shutdown Hook）的方法，
        // 它会在 JVM 关闭时执行。JVM 关闭的常见场景包括：
        // 正常关闭：
        // 1程序执行完毕。
        // 3调用 System.exit()。
        // 用户按下 Ctrl+C（中断信号）。
        // 强制关闭：
        // 1使用命令行终止进程（例如通过任务管理器或 kill 命令）。
        // 2系统崩溃或断电等异常情况。
        new Thread(() -> {
            System.exit(1);//停止程序
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
