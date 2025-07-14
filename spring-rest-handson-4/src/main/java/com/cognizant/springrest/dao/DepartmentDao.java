package com.cognizant.springrest.dao;

import com.cognizant.springrest.exception.DepartmentNotFoundException;
import com.cognizant.springrest.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static List<Department> departmentList = new ArrayList<>();

    static {
        departmentList.add(new Department(1, "HR"));
        departmentList.add(new Department(2, "IT"));
        departmentList.add(new Department(3, "Finance"));
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }

    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    public void updateDepartment(Department updated) throws DepartmentNotFoundException {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId().equals(updated.getId())) {
                departmentList.set(i, updated);
                return;
            }
        }
        throw new DepartmentNotFoundException("Department with ID " + updated.getId() + " not found");
    }

    public void deleteDepartment(int id) throws DepartmentNotFoundException {
        Department deptToDelete = null;
        for (Department dept : departmentList) {
            if (dept.getId() == id) {
                deptToDelete = dept;
                break;
            }
        }
        if (deptToDelete != null) {
            departmentList.remove(deptToDelete);
        } else {
            throw new DepartmentNotFoundException("Department with ID " + id + " not found");
        }
    }
}
