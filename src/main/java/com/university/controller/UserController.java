package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.User;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "user")
public class UserController extends CrudController<User> {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected CrudService<User> getService() {
        return userService;
    }
}
