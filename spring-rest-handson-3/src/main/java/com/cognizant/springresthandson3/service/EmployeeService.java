package com.cognizant.springresthandson3.service;

import com.cognizant.springresthandson3.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
}
