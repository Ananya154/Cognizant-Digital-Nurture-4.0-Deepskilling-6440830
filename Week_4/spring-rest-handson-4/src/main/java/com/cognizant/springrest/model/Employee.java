package com.cognizant.springrest.model;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {

    @NotNull
    private Integer id;

    @NotNull @NotBlank @Size(min = 1, max = 30)
    private String name;

    @NotNull @Min(0)
    private Double salary;

    @NotNull
    private Boolean permanent;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotNull
    private Department department;

    private List<Skill> skills;
    
    public Employee() {}

    public Employee(Integer id, String name, Double salary, Boolean permanent,
                    Date dateOfBirth, Department department, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.skills = skills;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Boolean getPermanent() { return permanent; }
    public void setPermanent(Boolean permanent) { this.permanent = permanent; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary +
                ", permanent=" + permanent + ", dateOfBirth=" + dateOfBirth +
                ", department=" + department + ", skills=" + skills + "]";
    }
}
