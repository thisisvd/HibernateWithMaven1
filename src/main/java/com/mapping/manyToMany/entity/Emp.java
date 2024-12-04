package com.mapping.manyToMany.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Emp {

    @Id
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name")
    private String empName;

    @ManyToMany
    @JoinTable(
            // rename the table name
            name = "emp_learn_proj",
            // rename the first column name i.e, employees_emp_id
            joinColumns = {@JoinColumn(name = "eid")},
            // rename the second column name i.e, projects_project_id-
            inverseJoinColumns = {@JoinColumn(name = "pid")}
    )
    private List<Project> projects;

    public Emp() {}

    public Emp(int empId, String empName, List<Project> projects) {
        this.empId = empId;
        this.empName = empName;
        this.projects = projects;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}