package com.university.service;

import com.university.crud.CrudService;
import com.university.entity.User;
import com.university.entity.dto.UserRegistrationDTO;

import java.util.Collection;
import java.util.Optional;

public interface UserService extends CrudService<User> {

    Optional<User> getUserById(long id);
    Optional<User> getUserByEmail(String email);
    Collection<User> getAllUsers();
    User create(UserRegistrationDTO form);

}
