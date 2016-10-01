package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.User;
import com.university.entity.enumeration.EmploymentForm;
import com.university.entity.enumeration.Position;
import com.university.service.DataProvider;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<User> {

    private UserService userService;

    private DataProvider dataProvider;

    @Autowired
    UserController(UserService userService, DataProvider dataProvider) {
        this.userService = userService;
        this.dataProvider = dataProvider;
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
}
