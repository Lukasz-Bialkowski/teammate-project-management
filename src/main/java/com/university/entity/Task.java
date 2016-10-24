package com.university.entity;

import com.university.entity.enumeration.TaskStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<WorkLog> worklogs = new HashSet<>();

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

    public Set<WorkLog> getWorklogs() {
        return worklogs;
    }

    public void setWorklogs(Set<WorkLog> worklogs) {
        this.worklogs = worklogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task other = (Task) o;
        return this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
