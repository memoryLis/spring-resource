package com.liang.springioc.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ClassName: Aspect
 * Package: com.liang.springioc.aop
 * Description:
 *
 * @Author liang
 * @Create 2025/9/7 20:16
 * @Version jdk17.0
 */
@org.aspectj.lang.annotation.Aspect
@Component // 3. 同样需要被Spring管理
public class Aspect {

    @Pointcut("execution(* com.liang.springioc.aop.B.*(..))")
    public void pcB() {
    }

    @Pointcut("execution(* com.liang.springioc.aop.A.*(..))")
    public void pcA() {
    }

    @Around("pcA()")
    public Object logMethodExecutionA(ProceedingJoinPoint joinPoint) {
        // 获取方法签名信息
        String methodNameA = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // 5.1 方法执行前：记录日志
        System.out.println("[AOP日志] 开始执行方法:a " + methodNameA + " | 参数: " + java.util.Arrays.toString(args));
        Object result = null;
        Object target = joinPoint.getTarget();
        try {
             result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return result;

    }


    @Around("pcB()")
    public Object logMethodExecutionB(ProceedingJoinPoint joinPoint) {
        // 获取方法签名信息
        String methodNameB = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // 5.1 方法执行前：记录日志
        System.out.println("[AOP日志] 开始执行方法:b " + methodNameB + " | 参数: " + java.util.Arrays.toString(args));
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return result;

    }
}
