package com.suhail.aop.AOP.dao;

import com.suhail.aop.AOP.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOimpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " from AccountDaoImple");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " within the get name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " with in the set name");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " within the get service code");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " with in the set service code");
        this.serviceCode = serviceCode;
    }
}
