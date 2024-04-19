package com.suhail.cruddemo.suhail.dao;

import com.suhail.cruddemo.suhail.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
