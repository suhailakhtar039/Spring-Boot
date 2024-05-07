package com.suhail.aop.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsyncAspect {
    @Before("forDaoPackageNoGetterSetter()")
    public void logToCloud(){
        System.out.println("============> Logging to cloud async");
    }
}
