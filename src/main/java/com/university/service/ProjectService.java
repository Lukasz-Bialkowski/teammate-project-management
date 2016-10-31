package com.university.service;

import com.university.crud.CrudService;
import com.university.entity.Project;

public interface ProjectService extends CrudService<Project> {

    void sendEventUpdateMail(Project project);

    void sendDocumentUpdateMail(Project project);

    void sendProjectPinnedToManagerMail(Project project);

    void sendTaskStatusUpdateMail(Project project);
}
