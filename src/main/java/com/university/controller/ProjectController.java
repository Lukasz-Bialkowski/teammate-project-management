package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Project;
import com.university.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController extends CrudController<Project> {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    protected CrudService<Project> getService() {
        return projectService;
    }


}
