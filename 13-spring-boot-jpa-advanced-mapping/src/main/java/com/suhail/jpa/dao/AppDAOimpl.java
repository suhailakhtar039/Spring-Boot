package com.suhail.jpa.dao;

import com.suhail.jpa.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class AppDAOimpl implements  AppDAO{
    private EntityManager entityManager;

    @Autowired
    public AppDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }
}
