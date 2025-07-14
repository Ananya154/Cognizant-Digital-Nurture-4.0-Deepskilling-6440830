package com.cognizant.springrest.service;

import com.cognizant.springrest.dao.EmployeeDao;
import com.cognizant.springrest.exception.EmployeeNotFoundException;
import com.cognizant.springrest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        employeeDao.deleteEmployee(id);
    }
}