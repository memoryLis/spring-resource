package com.liang.tool.subscribe;

import com.liang.beandefinition.bean.User;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: Test
 * Package: com.liang.tool.subscribe
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 18:57
 * @Version jdk17.0
 */
public class Test {
    @org.junit.Test
    public void testMulticaster() {
        // 1、创建一个事件发布器
        SimpleApplicationEventMulticaster multicaster
                = new SimpleApplicationEventMulticaster();
        // 2、添加监听器
        multicaster.addApplicationListener(new EmailListener());
        multicaster.addApplicationListener(new MessageListener());

        // 3、发布事件
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setUser(new User(12,"tom"));
        orderDetail.setDate(new Date());

        OrderEvent event = new OrderEvent(orderDetail);

        // 4、多线程执行
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        multicaster.setTaskExecutor(threadPool);

        // 5、添加异常处理器
        // ErrorHandler errorHandler = t -> log.error("事件处理失败 -> {}",t.getMessage());
        // multicaster.setErrorHandler(errorHandler);

        // 6、发布事件
        multicaster.multicastEvent(event);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
