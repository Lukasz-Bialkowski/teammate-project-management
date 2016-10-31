package com.university.service.impl;

import com.university.constants.ApplicationConstants;
import com.university.crud.Impl.AbstractCrudService;
import com.university.entity.User;
import com.university.repository.UserRepository;
import com.university.service.EmailSenderService;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractCrudService<User> implements UserService {

    private UserRepository userRepository;
    private EmailSenderService emailSender;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EmailSenderService emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User create() {
        return new User();
    }

    @Async
    @Override
    public void sendAccountCreatedMail(User user) {
        emailSender.sendHtmlMessage(user.getEmail(),
                ApplicationConstants.NEW_ACCOUNT_EMAIL_TITLE,
                ApplicationConstants.generateAccountCreatedEmail(user.getName(), user.getSurname()));
    }
}
