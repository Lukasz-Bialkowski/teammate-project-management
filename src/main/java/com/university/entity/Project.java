package com.university.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project extends EntityBase {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "department")
    private String department;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "")
//    private Set<User> employees = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "project_manager")
    private User manager;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "product_description")
    private String productDescription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
