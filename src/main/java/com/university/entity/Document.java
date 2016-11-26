package com.university.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Document extends EntityBase {

    @Column(name = "title")
    private String title;

    @Column(name = "html_content", length = 5000)
    private String htmlContent;

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
