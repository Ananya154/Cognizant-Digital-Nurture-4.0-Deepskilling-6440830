package com.cognizant.springrest.controller;

import com.cognizant.springrest.exception.DepartmentNotFoundException;
import com.cognizant.springrest.model.Department;
import com.cognizant.springrest.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public void addDepartment(@RequestBody @Valid Department department) {
        departmentService.addDepartment(department);
    }

    @PutMapping
    public void updateDepartment(@RequestBody @Valid Department department) throws DepartmentNotFoundException {
        departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable int id) throws DepartmentNotFoundException {
        departmentService.deleteDepartment(id);
    }
}
