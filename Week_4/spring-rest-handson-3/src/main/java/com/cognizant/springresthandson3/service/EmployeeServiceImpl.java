package com.cognizant.springresthandson3.service;

import com.cognizant.springresthandson3.dao.EmployeeDao;
import com.cognizant.springresthandson3.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getAllEmployees()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
