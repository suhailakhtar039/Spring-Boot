package com.suhail.cruddemo.suhail.dao;

import com.suhail.cruddemo.suhail.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
