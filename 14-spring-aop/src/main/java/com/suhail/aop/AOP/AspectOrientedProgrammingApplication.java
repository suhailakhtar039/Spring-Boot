package com.suhail.aop.AOP;

import com.suhail.aop.AOP.dao.AccountDAO;
import com.suhail.aop.AOP.dao.MembershipDAO;
import com.suhail.aop.AOP.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
            // demoTheBeforeAdvice(accountDAO, membershipDAO);
            // demoTheAfterAdvice(accountDAO);
            // demoTheAfterThrowingAdvice(accountDAO);
            // demoTheAfterFinallyAdvice(accountDAO);
            // demoTheAroundAdvice(trafficFortuneService);
            // demoTheAroundAdviceHandleException(trafficFortuneService);
            demoTheAroundAdviceRethrowException(trafficFortuneService);
        };

    }

    private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("calling get fortune");
        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("calling get fortune");
        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("calling get fortune");

        String data = trafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAfterFinallyAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("Caught The Exception AfterThrowAdvice: " + exc);
        }

        System.out.println("\n\nMain program: demoAfterThrowingAdvice");
        System.out.println(accounts);
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("Caught The Exception AfterThrowAdvice: " + exc);
        }

        System.out.println("\n\nMain program: demoAfterThrowingAdvice");
        System.out.println(accounts);
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain program: demoTheAfterAdvice");
        System.out.println(accounts);
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();
        account.setName("Demo");
        account.setLevel("4");

        accountDAO.addAccount(account, true);
        membershipDAO.addAccount();

        // call the account getter/setter
        accountDAO.setName("Suhail");
        accountDAO.setServiceCode("Silver");

        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();
    }

}
