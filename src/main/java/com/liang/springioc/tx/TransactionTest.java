package com.liang.springioc.tx;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: TransactionTest
 * Package: com.liang.springioc.tx
 * Description:
 *
 * @Author liang
 * @Create 2025/7/2 10:38
 * @Version jdk17.0
 */
public class TransactionTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.liang.springioc.tx");
        AccountServiceLiang bean = applicationContext.getBean(AccountServiceLiang.class);
        bean.transfer("liang","guang",100.0);

    }
}
