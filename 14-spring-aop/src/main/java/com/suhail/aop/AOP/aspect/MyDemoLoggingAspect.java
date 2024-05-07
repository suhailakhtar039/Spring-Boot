package com.suhail.aop.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.suhail.aop.AOP.dao.*.*(..))")
    private void forDaoPackage(){}

    // pointcut for getter
    @Pointcut("execution(* com.suhail.aop.AOP.dao.*.get*())")
    private void getter(){}
    // pointcut for setter
    @Pointcut("execution(* com.suhail.aop.AOP.dao.*.set*())")
    private void setter(){}

    // pointcut for package removing getter and setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("============> executing before advice on addAccount");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("============> executing before advice from perform Api analytics");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void logToCloud(){
        System.out.println("============> Logging to cloud async");
    }

}
