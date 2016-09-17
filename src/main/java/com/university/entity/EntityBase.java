package com.university.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_update", nullable = true)
    private Date dateUpdate;

    public EntityBase() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateUpdate() {
        return this.dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @PrePersist
    public void prePersist() {
        this.dateUpdate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.dateUpdate = new Date();
    }
}
