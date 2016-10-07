package com.university.exception;

import com.university.entity.User;

public class ForbiddenException extends RuntimeException {

    private User user;
    private String resource;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
