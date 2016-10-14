package com.university.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Event extends EntityBase {

    @Column(name = "name")
    private String name;

    @Column(name = "event_start_date")
    private Date eventStartDate = new Date();

    @Column(name = "event_end_date")
    private Date eventEndDate = new Date();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private User owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
