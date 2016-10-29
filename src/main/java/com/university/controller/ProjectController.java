package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Project;
import com.university.entity.User;
import com.university.security.CurrentUser;
import com.university.service.ProjectService;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/project")
public class ProjectController extends CrudController<Project> {

    private ProjectService projectService;
    private UserService userService;

    @Autowired
    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @Override
    protected CrudService<Project> getService() {
        return projectService;
    }

    @RequestMapping(value = "/memberprojects", method = RequestMethod.GET)
    public Set<Project> userLoggedIn(Authentication authentication) {
        CurrentUser userDetails = (CurrentUser) authentication.getPrincipal();
        User loggedUser = userService.get(userDetails.getUser().getId());

        return loggedUser.getProjects();
    }
}
