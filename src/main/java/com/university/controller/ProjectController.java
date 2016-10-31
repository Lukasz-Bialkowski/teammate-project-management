package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Project;
import com.university.service.ProjectService;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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

    @Override
    public Project save(@RequestBody Project model, HttpServletResponse response) {
        projectService.sendProjectPinnedToManagerMail(model);
        return super.save(model, response);
    }
}
