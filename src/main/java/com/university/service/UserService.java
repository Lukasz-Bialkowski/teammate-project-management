package com.university.service;

import com.university.crud.CrudService;
import com.university.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User> {

    Optional<User> getUserByEmail(String email);

    void sendAccountCreatedMail(User user);
}
