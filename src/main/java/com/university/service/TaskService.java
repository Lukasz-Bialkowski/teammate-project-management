package com.university.service;

import com.university.crud.CrudService;
import com.university.entity.Task;

public interface TaskService extends CrudService<Task> {

    void sendTaskStatusUpdateMail(Task task);

    void sendTaskPinnedMail(Task task);
}
