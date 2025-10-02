package com.liang.springioc.FinishBeanFactoryInitialization.cicular;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyAspect
 * Package: com.liang.springioc.FinishBeanFactoryInitialization.cicular
 * Description:
 *
 * @Author liang
 * @Create 2025/7/1 10:33
 * @Version jdk17.0
 */
@Aspect
@Component
public class MyAspect {
    // 定义切点表达式，匹配 com.liang 包下的所有方法
    @Pointcut("execution(* com.liang.springioc.FinishBeanFactoryInitialization.cicular.*.*(..))")
    public void myPointcut() {
        // 方法体为空，仅作为切点的标识
    }
    @Before("myPointcut()")
    public void beforeAdvice() {
    }
}
