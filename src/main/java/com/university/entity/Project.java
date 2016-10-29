package com.university.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project extends EntityBase {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "department")
    private String department;

    @ManyToOne
    @JoinColumn(name = "project_manager")
    private User manager;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "product_description")
    private String productDescription;

    @OneToMany
    private Set<Event> events = new HashSet<>();

    @OneToMany
    private Set<Document> documents = new HashSet<>();

    @OneToMany
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany
    @JoinTable(name="user_project", joinColumns=@JoinColumn(name="project_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
    private Set<User> members = new HashSet<>();

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

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    /**
     * Add resources
     */

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void addMember(User user) {
        this.members.add(user);
    }
}
