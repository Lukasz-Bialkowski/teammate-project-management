package com.university.service.impl;

import com.university.constants.ApplicationConstants;
import com.university.crud.Impl.AbstractCrudService;
import com.university.entity.Task;
import com.university.entity.User;
import com.university.repository.TaskRepository;
import com.university.service.EmailSenderService;
import com.university.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends AbstractCrudService<Task> implements TaskService {

    private TaskRepository taskRepository;
    private EmailSenderService emailSender;

    @Autowired
    TaskServiceImpl(TaskRepository taskRepository, EmailSenderService emailSender) {
        this.taskRepository = taskRepository;
        this.emailSender = emailSender;
    }

    @Override
    protected JpaRepository<Task, Long> getRepository() {
        return taskRepository;
    }

    @Override
    public Task create() {
        return new Task();
    }

    @Async
    @Override
    public void sendTaskStatusUpdateMail(Task task) {
        User contractor = task.getContractor();
        emailSender.sendHtmlMessage(contractor.getEmail(),
                ApplicationConstants.TASK_STATUS_UPDATE_EMAIL_TEMPLATE,
                ApplicationConstants.generateTaskStatusUpdateEmail(contractor.getName(), contractor.getSurname()));
    }

    @Async
    @Override
    public void sendTaskPinnedMail(Task task) {
        User contractor = task.getContractor();
        emailSender.sendHtmlMessage(contractor.getEmail(),
                ApplicationConstants.TASK_PINNED_TO_USER_EMAIL_TITLE,
                ApplicationConstants.generateTaskPinnedEmail(contractor.getName(), contractor.getSurname()));
    }
}
