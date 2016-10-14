package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Document;
import com.university.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docs")
public class DocsController extends CrudController<Document> {

    private DocumentService documentService;

    @Autowired
    public DocsController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Override
    protected CrudService<Document> getService() {
        return documentService;
    }
}
