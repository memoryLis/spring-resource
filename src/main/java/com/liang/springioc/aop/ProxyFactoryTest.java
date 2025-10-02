package com.liang.springioc.aop;


import com.liang.springioc.aop.impl.UserServiceImpl;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;


/**
 * ClassName: ProxyFactoryTest
 * Package: com.liang.springioc.aop
 * Description:
 *
 * @Author liang
 * @Create 2025/7/1 16:28
 * @Version jdk17.0
 */
public class ProxyFactoryTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MethodBeforeAdvice beforeAdvice = new MethodBeforeAdvice(){
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before advice");
            }
        };
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(userService);
        proxyFactory.addAdvice(beforeAdvice);
        proxyFactory.addInterface(UserService.class);
        UserService proxy =(UserService) proxyFactory.getProxy();
        proxy.add();


    }
}
