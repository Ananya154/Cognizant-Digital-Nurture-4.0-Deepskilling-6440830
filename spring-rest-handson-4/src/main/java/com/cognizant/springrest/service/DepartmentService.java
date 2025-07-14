package com.cognizant.springrest.service;

import com.cognizant.springrest.dao.DepartmentDao;
import com.cognizant.springrest.exception.DepartmentNotFoundException;
import com.cognizant.springrest.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    public void updateDepartment(Department department) throws DepartmentNotFoundException {
        departmentDao.updateDepartment(department);
    }

    public void deleteDepartment(int id) throws DepartmentNotFoundException {
        departmentDao.deleteDepartment(id);
    }
}
