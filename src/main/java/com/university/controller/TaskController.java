package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Project;
import com.university.entity.Task;
import com.university.service.ProjectService;
import com.university.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@RestController
@RequestMapping("/project/{projectId}/task")
public class TaskController extends CrudController<Task> {

    private TaskService taskService;
    private ProjectService projectService;

    @Autowired
    public TaskController(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @Override
    protected CrudService<Task> getService() {
        return taskService;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/projecttasks")
    @ResponseBody
    public Set<Task> projectTasks(@PathVariable("projectId") Long projectId) {
        Project project = projectService.get(projectId);
        return project.getTasks();
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/saveprojecttask"})
    @ResponseBody
    public Task saveProjectTask(@PathVariable("projectId") Long projectId, @RequestBody Task model, HttpServletResponse response) {
        Project project = projectService.get(projectId);
        project.addTask(model);
        Task savedTask = taskService.save(model);
        projectService.save(project);
        return savedTask;
    }

}
