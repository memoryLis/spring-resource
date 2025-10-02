package com.liang.springioc.aop.impl;

import com.liang.springioc.aop.UserService;

/**
 * ClassName: UserServiceImpl
 * Package: com.liang.springioc.aop.impl
 * Description:
 *
 * @Author liang
 * @Create 2025/7/1 16:30
 * @Version jdk17.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加了一个用户");
    }
}
