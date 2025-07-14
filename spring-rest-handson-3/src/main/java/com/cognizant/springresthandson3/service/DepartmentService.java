package com.cognizant.springresthandson3.service;

import com.cognizant.springresthandson3.dao.DepartmentDao;
import com.cognizant.springresthandson3.model.Department;
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
}
