package com.liang.tool.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Objects;

/**
 * ClassName: test
 * Package: com.liang.tool.spel
 * Description:
 *
 * @Author liang
 * @Create 2025/6/26 15:59
 * @Version jdk17.0
 */
public class test {
    public static void main(String[] args) {
        /**
         * SpEL（Spring Expression Language）是一种功能强大的表达式语言
         */

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("1+2");
        Object message =  exp.getValue();
        System.out.println(message);
    }
}
