package com.ssm.chapter10.el.pojo;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;

/**
 * EL 表达式2
 */
public class SpelExpression2 {

    public static void main(String[] args) {
        ExpressionParser parser = getExpressionParser();
        Role role = new Role(1L, "yangxuan", "aaa");
        Expression note = parser.parseExpression("note");
        String value = (String) note.getValue(role);
        System.out.println(value);

        //
        EvaluationContext ctx = new StandardEvaluationContext(role);
        parser.parseExpression("note").setValue(ctx, "new_note");
        String note1 = parser.parseExpression("note").getValue(ctx, String.class);
        System.out.println(note1);


        ArrayList<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");

        ctx.setVariable("list", list);

        parser.parseExpression("#list[1]").setValue(ctx, "update_value2");
        Object list1 = parser.parseExpression("#list[1]").getValue(ctx);

        String s = parser.parseExpression("getRoleName()").getValue(ctx, String.class);
        System.out.println(s);
        System.out.println(list1);




    }

    private static ExpressionParser getExpressionParser() {
        return new SpelExpressionParser();
    }
}
