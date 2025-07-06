package com.learntech.springdata.model;

import jakarta.persistence.*;
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Student [code=" + code + ", name=" + name + "]";
    }
}
