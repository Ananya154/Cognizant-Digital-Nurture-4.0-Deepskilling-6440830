package com.hands.on.differencesex4.controller;

import com.hands.on.differencesex4.entity.Employee;
import com.hands.on.differencesex4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee saved successfully!";
    }
    @GetMapping("/")
    public String home() {
        return "Welcome to the Employee API! Use POST /api/employees/add to add an employee.";
    }
}
