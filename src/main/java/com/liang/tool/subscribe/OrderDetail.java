package com.liang.tool.subscribe;

import com.liang.beandefinition.bean.User;
import java.util.Date;

/**
 * ClassName: OrderDetail
 * Package: com.liang.tool.subscribe
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 19:30
 * @Version jdk17.0
 */
public class OrderDetail {
    private User user;
    private Date date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}