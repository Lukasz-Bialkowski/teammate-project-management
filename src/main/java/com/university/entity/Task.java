package com.university.entity;

import com.university.entity.enumeration.TaskStatus;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task extends EntityBase {

    @Column(name = "name")
    private String name;

    @Column(name = "story_points")
    private Integer storyPoints;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private User contractor;

    @Column(name = "estimated_hours")
    private Double estimatedHours;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private TaskStatus status = TaskStatus.TODO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
    }

    public User getContractor() {
        return contractor;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }

    public Double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
