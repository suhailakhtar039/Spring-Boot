package com.suhail.aop.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void com.suhail.aop.AOP.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("============> executing before advice on addAccount");
    }
}
