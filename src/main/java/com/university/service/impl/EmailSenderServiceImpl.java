package com.university.service.impl;

import com.university.service.EmailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailSenderServiceImpl.class);
    private JavaMailSender javaMailSender;
//    private TemplateEngine templateEngine;

    @Autowired
    public EmailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMessage(String to, String subject, String text) {
        sendM(to, subject, text, false);
    }

    @Override
    public void sendHtmlMessage(String to, String subject, String htmlBody) {
        sendM(to, subject, htmlBody, true);
    }

//    @Override
//    public void sendTemplateMessage(String to, String subject, String templateName, Context context) {
//        String body = templateEngine.process(templateName, context);
//        sendM(to, subject, body, true);
//    }

    private void sendM(String to, String subject, String text, Boolean isHtml) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            javaMailSender.send(mail);
            LOGGER.info("Sending email '{}' to: {}", subject, to);
        } catch (Exception e) {
            LOGGER.error("Problem with sending email to: {}, error message: {}", to, e.getMessage());
        }
    }

}
