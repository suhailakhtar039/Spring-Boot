package com.suhail.aop.AOP.dao;

import com.suhail.aop.AOP.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOimpl implements AccountDAO{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " from AccountDaoImple");
        return false;
    }
}
