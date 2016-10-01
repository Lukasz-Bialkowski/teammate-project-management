package com.university.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task extends EntityBase {

    @Column(name = "name")
    private String name;

    @Column(name = "story_points")
    private Integer storyPoints;

    public Task() {
    }

    public Task(String name, int storyPoints) {
        this.name = name;
        this.storyPoints = storyPoints;
    }

    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
    }

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
