package com.cognizant.springrest.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.cognizant.springrest.exception.EmployeeNotFoundException;
import com.cognizant.springrest.model.Department;
import com.cognizant.springrest.model.Employee;
import com.cognizant.springrest.model.Skill;

@Repository
public class EmployeeDao {

    private static List<Employee> employeeList;

    static {
        try {
            employeeList = new ArrayList<>();

            Employee e1 = new Employee(
                    1, "John", 35000.0, true,
                    new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1994"),
                    new Department(1, "HR"),
                    Arrays.asList(new Skill(1, "Java"), new Skill(2, "Spring"))
            );

            Employee e2 = new Employee(
                    2, "Jane", 50000.0, false,
                    new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1992"),
                    new Department(2, "IT"),
                    Arrays.asList(new Skill(3, "JavaScript"), new Skill(4, "React"))
            );

            employeeList.add(e1);
            employeeList.add(e2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void updateEmployee(Employee updatedEmployee) throws EmployeeNotFoundException {
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(updatedEmployee.getId())) {
                employeeList.set(i, updatedEmployee);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException("Employee with ID " + updatedEmployee.getId() + " not found");
        }
    }

    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        Employee employeeToDelete = null;
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                employeeToDelete = emp;
                break;
            }
        }
        if (employeeToDelete != null) {
            employeeList.remove(employeeToDelete);
        } else {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }
}
