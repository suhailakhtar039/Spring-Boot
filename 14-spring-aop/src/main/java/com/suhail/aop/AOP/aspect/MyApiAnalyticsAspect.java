package com.suhail.aop.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.suhail.aop.AOP.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("============> executing before advice from perform Api analytics");
    }
}
