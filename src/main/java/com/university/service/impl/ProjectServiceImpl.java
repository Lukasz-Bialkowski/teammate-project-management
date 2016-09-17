package com.university.service.impl;

import com.university.crud.Impl.AbstractCrudService;
import com.university.entity.Project;
import com.university.repository.ProjectRepository;
import com.university.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends AbstractCrudService<Project> implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create() {
        return new Project();
    }

    @Override
    protected JpaRepository<Project, Long> getRepository() {
        return projectRepository;
    }
}
