package com.university.service.impl;

import com.university.crud.CrudService;
import com.university.crud.Impl.AbstractCrudService;
import com.university.entity.Task;
import com.university.repository.TaskRepository;
import com.university.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends AbstractCrudService<Task> implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    protected JpaRepository<Task, Long> getRepository() {
        return taskRepository;
    }

    @Override
    public Task create() {
        return new Task();
    }
}
