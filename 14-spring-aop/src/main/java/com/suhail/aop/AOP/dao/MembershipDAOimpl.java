package com.suhail.aop.AOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOimpl implements MembershipDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ":  DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }
}
