package com.liang.tool.subscribe;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.liang.tool.subscribe.OrderEvent;

/**
 * ClassName: EmailListener
 * Package: com.liang.tool.subscribe
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 19:15
 * @Version jdk17.0
 */
@Component
public class EmailListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        System.out.println("发送邮件..." + event.getSource());
        if(event.getSource() instanceof OrderDetail){
            OrderDetail orderDetail = (OrderDetail) event.getSource();
            System.out.println("用户邮件：" + orderDetail.getUser().getName() + "，订单：" + orderDetail.getDate());

        }
    }
}