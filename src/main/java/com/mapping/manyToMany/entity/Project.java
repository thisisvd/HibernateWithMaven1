package com.mapping.manyToMany.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {

    @Id
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    // mappedBy = "projects" : Means only 1 extra table will be created and its by projects column in Emp
    // so the below will just follow ManyToMany principle
    @ManyToMany(mappedBy = "projects")
    private List<Emp> employees;

    public Project() {}

    public Project(int projectId, String projectName, List<Emp> employees) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.employees = employees;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Emp> employees) {
        this.employees = employees;
    }
}