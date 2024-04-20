package com.suhail.cruddemo.suhail.rest;

import com.suhail.cruddemo.suhail.dao.EmployeeDAO;
import com.suhail.cruddemo.suhail.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeDAO.findAll();
    }

}
