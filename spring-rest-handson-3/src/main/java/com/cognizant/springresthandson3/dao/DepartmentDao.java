package com.cognizant.springresthandson3.dao;

import com.cognizant.springresthandson3.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    @Autowired
    @Qualifier("departmentList")
    private List<Department> departmentList;

    public List<Department> getAllDepartments() {
        return departmentList;
    }
}
