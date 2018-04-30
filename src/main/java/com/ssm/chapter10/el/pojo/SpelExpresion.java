package com.ssm.chapter10.el.pojo;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * EL 表达式1
 */
public class SpelExpresion {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //
        Expression exp = parser.parseExpression("'hello world'");
        String  value = (String) exp.getValue();
        System.out.println(value);

        // el 访问普通方法
         exp = parser.parseExpression("'hello world'.charAt(0)");
        char ch = (char) exp.getValue();
        System.out.println(ch);

        // gettter
        exp = parser.parseExpression("'hello world'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        System.out.println(bytes);

        // 通过el访问属性
        exp = parser.parseExpression("'hello world'.bytes.length");
        int len = (int) exp.getValue();
        System.out.println(len);

        exp = parser.parseExpression("new String('abc')");
        String  value1 = (String) exp.getValue();
        System.out.println(value1);


    }
}
