package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Task;
import com.university.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController extends CrudController<Task> {

    private TaskService taskService;

    @Autowired
    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    protected CrudService<Task> getService() {
        return taskService;
    }
}
