package com.liang.tool.subscribe;

import org.springframework.context.ApplicationEvent;

/**
 * ClassName: OrderEvent
 * Package: com.liang.tool.subscribe
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 19:25
 * @Version jdk17.0
 */
public class OrderEvent extends ApplicationEvent {
    public OrderEvent(OrderDetail source) {
        super(source);
    }

    @Override
    public OrderDetail getSource() {
        return (OrderDetail) super.getSource();
    }
}