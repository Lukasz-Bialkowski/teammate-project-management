package com.university.service.impl;

import com.university.crud.Impl.AbstractCrudService;
import com.university.entity.Document;
import com.university.repository.DocumentRepository;
import com.university.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl extends AbstractCrudService<Document> implements DocumentService {

    private DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document create() {
        return new Document();
    }

    @Override
    protected JpaRepository<Document, Long> getRepository() {
        return documentRepository;
    }
}
