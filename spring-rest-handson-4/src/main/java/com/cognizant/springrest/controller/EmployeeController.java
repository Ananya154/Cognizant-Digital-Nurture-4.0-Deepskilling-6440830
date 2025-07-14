package com.cognizant.springrest.controller;

import com.cognizant.springrest.exception.EmployeeNotFoundException;
import com.cognizant.springrest.model.Employee;
import com.cognizant.springrest.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public void addEmployee(@RequestBody @Valid Employee employee) {
        employeeService.addEmployee(employee);
    }
    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
        employeeService.deleteEmployee(id);
    }
}
