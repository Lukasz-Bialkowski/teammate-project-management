package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.User;
import com.university.entity.enumeration.EmploymentForm;
import com.university.entity.enumeration.Position;
import com.university.entity.enumeration.Role;
import com.university.service.DataProvider;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<User> {

    private UserService userService;
    private DataProvider dataProvider;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, DataProvider dataProvider, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.dataProvider = dataProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected CrudService<User> getService() {
        return userService;
    }

    @RequestMapping(value = "/positionsList", method = RequestMethod.GET)
    public ResponseEntity<List<Position>> positionsList() {
        return new ResponseEntity<>(dataProvider.getAllPositions(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employmentFormsList", method = RequestMethod.GET)
    public ResponseEntity<List<EmploymentForm>> employmentFormsList() {
        return new ResponseEntity<>(dataProvider.getAllEmploymentForms(), HttpStatus.OK);
    }

    @Override
    public User save(@RequestBody User model, HttpServletResponse response) {
        model.setPasswordHash(passwordEncoder.encode(model.getPasswordHash()));
        model.setRole(Role.ADMIN);
        userService.sendAccountCreatedMail(model);
        return super.save(model, response);
    }
}
