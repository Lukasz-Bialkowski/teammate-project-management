package com.university.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Project extends EntityBase {

    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
