package com.university.service.impl;

import com.university.constants.ApplicationConstants;
import com.university.crud.Impl.AbstractCrudService;
import com.university.entity.Project;
import com.university.entity.User;
import com.university.repository.ProjectRepository;
import com.university.service.EmailSenderService;
import com.university.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProjectServiceImpl extends AbstractCrudService<Project> implements ProjectService {

    private ProjectRepository projectRepository;
    private EmailSenderService emailSender;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, EmailSenderService emailSender) {
        this.projectRepository = projectRepository;
        this.emailSender = emailSender;
    }

    @Override
    public Project create() {
        return new Project();
    }

    @Override
    protected JpaRepository<Project, Long> getRepository() {
        return projectRepository;
    }

    @Async
    @Override
    public void sendEventUpdateMail(Project project) {
        Set<User> members = project.getMembers();
        for (User member : members) {
            emailSender.sendHtmlMessage(member.getEmail(),
                    ApplicationConstants.PROJECT_EVENT_UPDATE_EMAIL_TITLE,
                    ApplicationConstants.generateProjectEventUpdateEmail(member.getName(), member.getSurname()));
        }
    }

    @Async
    @Override
    public void sendDocumentUpdateMail(Project project) {
        Set<User> members = project.getMembers();
        for (User member : members) {
            emailSender.sendHtmlMessage(member.getEmail(),
                    ApplicationConstants.PROJECT_DOCUMENT_UPDATE_EMAIL_TITLE,
                    ApplicationConstants.generateProjectDocumentUpdateEmail(member.getName(), member.getSurname()));
        }
    }

    @Async
    @Override
    public void sendTaskStatusUpdateMail(Project project) {
        User manager = project.getManager();
        emailSender.sendHtmlMessage(manager.getEmail(),
                ApplicationConstants.TASK_STATUS_UPDATE_EMAIL_TEMPLATE,
                ApplicationConstants.generateTaskStatusUpdateEmail(manager.getName(), manager.getSurname()));
    }

    @Async
    @Override
    public void sendProjectPinnedToManagerMail(Project project) {
        User manager = project.getManager();
        emailSender.sendHtmlMessage(manager.getEmail(),
                ApplicationConstants.PROJECT_PINNED_TO_MANAGER_EMAIL_TITLE,
                ApplicationConstants.generateProjectPinnedEmail(manager.getName(), manager.getSurname()));
    }

}
