package com.hands.on.differencesex4.service;

import com.hands.on.differencesex4.entity.Employee;
import com.hands.on.differencesex4.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
        System.out.println("Saved using Spring Data JPA: " + employee);
    }
}
