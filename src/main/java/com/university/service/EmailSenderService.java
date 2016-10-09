package com.university.service;

public interface EmailSenderService {
    void sendMessage(String to, String subject, String text);

    void sendHtmlMessage(String to, String subject, String htmlBody);
//    void sendTemplateMessage(String to, String subject, String templateName, Context context);
}
