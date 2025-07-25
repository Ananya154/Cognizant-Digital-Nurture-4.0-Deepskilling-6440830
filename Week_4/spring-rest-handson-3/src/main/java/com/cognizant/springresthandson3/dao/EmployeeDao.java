package com.cognizant.springresthandson3.dao;

import com.cognizant.springresthandson3.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    @Qualifier("employeeList")
    private List<Employee> employeeList;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int id) {
        for (Employee e : employeeList) {  
            if (e.getId() == id) return e;
        }
        return null;
    }

}
