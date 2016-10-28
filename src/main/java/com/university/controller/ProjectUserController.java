package com.university.controller;

import com.university.entity.Project;
import com.university.entity.User;
import com.university.service.ProjectService;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/project/{projectId}/user")
public class ProjectUserController {

    private UserService userService;
    private ProjectService projectService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ProjectUserController(UserService userService, ProjectService projectService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.projectService = projectService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/saveprojectmember"})
    @ResponseBody
    public User saveProjectMember(@PathVariable("projectId") Long projectId, @RequestBody User model, HttpServletResponse response) {
        model.setPasswordHash(passwordEncoder.encode(model.getPasswordHash()));
        Project project = projectService.get(projectId);
        project.addMember(model);
        User savedTask = userService.save(model);
        projectService.save(project);
        return savedTask;
    }

}
