package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Document;
import com.university.entity.Project;
import com.university.service.DocumentService;
import com.university.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@RestController
@RequestMapping("/project/{projectId}/document")
public class DocumentController extends CrudController<Document> {

    private DocumentService documentService;
    private ProjectService projectService;

    @Autowired
    public DocumentController(DocumentService documentService, ProjectService projectService) {
        this.documentService = documentService;
        this.projectService = projectService;
    }

    @Override
    protected CrudService<Document> getService() {
        return documentService;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/projectdocuments")
    @ResponseBody
    public Set<Document> projectDocuments(@PathVariable("projectId") Long projectId) {
        Project project = projectService.get(projectId);
        return project.getDocuments();
    }

    @Transactional
    @RequestMapping(method = {RequestMethod.POST}, value = {"/saveprojectdocument"})
    @ResponseBody
    public Document saveProjectDocument(@PathVariable("projectId") Long projectId, @RequestBody Document model, HttpServletResponse response) {
        Project project = projectService.get(projectId);
        project.addDocument(model);
        Document savedTask = documentService.save(model);
        projectService.save(project);

        projectService.sendDocumentUpdateMail(project);
        return savedTask;
    }
}
