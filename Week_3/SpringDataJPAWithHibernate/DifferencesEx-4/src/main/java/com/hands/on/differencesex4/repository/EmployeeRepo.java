package com.hands.on.differencesex4.repository;

import com.hands.on.differencesex4.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
