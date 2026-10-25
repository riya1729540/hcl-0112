package com.sampel.fielddi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp=ctx.getBean(Employee.class);
        String result=emp.displayAddress();
        System.out.println(result);
    }
}
