package com.university.entity;

import com.university.entity.enumeration.EmploymentForm;
import com.university.entity.enumeration.Position;
import com.university.entity.enumeration.Role;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User extends EntityBase {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth = new Date();

    @Column(name = "employment_form")
    private EmploymentForm employmentForm;

    @Column(name = "position")
    private Position position;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "social_ref")
    private SocialRef social;

//    @Column(name = "tasks")
//    @JsonProperty
//    @OneToMany(mappedBy = "contractor")
//    private Set<Task> tasks = new HashSet<>();

//    @Column(name = "events")
//    @OneToMany(mappedBy = "owner")
//    private Set<Event> events = new HashSet<>();

//    @OneToMany(mappedBy = "manager")
//    private Set<Project> managedProjects = new HashSet<>();

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public EmploymentForm getEmploymentForm() {
        return employmentForm;
    }

    public void setEmploymentForm(EmploymentForm employmentForm) {
        this.employmentForm = employmentForm;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "User{id: " + this.getId() + ",\n" +
                "email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }

    public SocialRef getSocial() {
        return social;
    }

    public void setSocial(SocialRef social) {
        this.social = social;
    }
}
