package com.suhail.aop.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {
    @Pointcut("execution(* com.suhail.aop.AOP.dao.*.*(..))")
    public void forDaoPackage(){}

    // pointcut for getter
    @Pointcut("execution(* com.suhail.aop.AOP.dao.*.get*())")
    public void getter(){}

    // pointcut for setter
    @Pointcut("execution(* com.suhail.aop.AOP.dao.*.set*())")
    public void setter(){}

    // pointcut for package removing getter and setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
