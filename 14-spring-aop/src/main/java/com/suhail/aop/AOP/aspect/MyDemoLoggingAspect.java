package com.suhail.aop.AOP.aspect;

import com.suhail.aop.AOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* com.suhail.aop.AOP.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: " + method);

        // print out the results of method call
        System.out.println("\n=====> result is: " + result);

        // let's modify it
        convertAccountNameToUpperCase(result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for(Account account : result){
            String name = account.getName().toUpperCase();
            account.setName(name);
        }
    }

    @Before("com.suhail.aop.AOP.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("============> executing before advice on addAccount");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object temp : args) {
            System.out.println(temp);
            if (temp instanceof Account) {
                Account account = (Account) temp;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }

    }

}
