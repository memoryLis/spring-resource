package com.liang.tool.subscribe;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: MessageListener
 * Package: com.liang.tool.subscribe
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 19:40
 * @Version jdk17.0
 */
@Component
public class MessageListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        System.out.println("发送短信..." + event.getSource());
        if(event.getSource() instanceof  OrderDetail){
            OrderDetail orderDetail = (OrderDetail) event.getSource();
            System.out.println("发送短信..." + orderDetail.getUser().getName());
            System.out.println("发送短信..." + orderDetail.getDate());
        }
    }
}