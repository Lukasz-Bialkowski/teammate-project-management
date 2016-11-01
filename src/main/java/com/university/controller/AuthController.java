package com.university.controller;

import com.university.entity.User;
import com.university.security.CurrentUser;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/credentials", method = RequestMethod.GET)
    public User userLoggedIn(Authentication authentication) {
        CurrentUser userDetails = (CurrentUser) authentication.getPrincipal();
        User loggedUser = userService.get(userDetails.getUser().getId());
        System.out.println("Logged in user details: " + loggedUser.toString());
        System.out.println("User logged role: " + userDetails.getRole());
        return loggedUser;
    }

}
