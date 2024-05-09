package com.suhail.aop.AOP.dao;

import com.suhail.aop.AOP.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts();
}
