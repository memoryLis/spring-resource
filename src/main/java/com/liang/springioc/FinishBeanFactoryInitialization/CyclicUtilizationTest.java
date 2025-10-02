package com.liang.springioc.FinishBeanFactoryInitialization;

import com.liang.springioc.FinishBeanFactoryInitialization.cicular.A;
import com.liang.springioc.FinishBeanFactoryInitialization.cicular.B;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: CyclicUtilizationTest
 * Package: com.liang.springioc.FinishBeanFactoryInitialization
 * Description:
 *
 * @Author liang
 * @Create 2025/6/30 20:16
 * @Version jdk17.0
 */
public class CyclicUtilizationTest {
    @Test
    public void test(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.liang.springioc.FinishBeanFactoryInitialization.cicular");
        A a = (A)applicationContext.getBean("a");
        B b  = (B)applicationContext.getBean("b");
        System.out.println(a.getClass());
        System.out.println(a.getB().getClass());
        System.out.println(b.getClass());
        System.out.println(b.getA().getClass());




    }
    /**
     * 整体过程
     * 1 创建b，尝试从缓存中获取，缓存中没有，进行创建b，创建成功后进行暴露，并放入三级缓存（对象工厂）
     * 2 对b进行依赖注入，发现需要a，尝试从缓存中获取，缓存中没有，进行创建a，创建成功后进行暴露，并放入三级缓存（对象工厂）
     * 3 对a进行依赖注入，发现需要b，尝试从缓存中获取，获得了一个早期暴露的引用b
     * ，并且对b进行代理，最后得到a(bp); 此时容器内 a(bp),bp(a=null)
     * 4 对a进行初始化，对a进行代理，对此ap 里面的b =null; ap结束，存入一级缓存中 此时生成ap（b=null）,但是生成代理中没有进注入
     * 5 对b进行初始化，不能在对b进行代理（之前处理了代理），拿到bp 里面的a =null; bp结束，存入一级缓存中
     * 6最后容器中bean a(bp),b(bp),bp(a=null),ap(b=null)
     *
     */
}
