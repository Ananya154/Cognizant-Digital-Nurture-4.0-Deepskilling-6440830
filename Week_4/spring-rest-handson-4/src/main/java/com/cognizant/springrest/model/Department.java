package com.cognizant.springrest.model;

import jakarta.validation.constraints.*;

public class Department {

    @NotNull
    private Integer id;

    @NotNull @NotBlank @Size(min = 1, max = 30)
    private String name;

    public Department() {}

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}
