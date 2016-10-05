package com.university.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @RequestMapping(value = "/credentials", method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

}
