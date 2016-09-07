package com.university.service.impl;

import com.university.crud.Impl.AbstractCrudService;
import com.university.entity.User;
import com.university.entity.dto.UserRegistrationDTO;
import com.university.repository.UserRepository;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractCrudService<User> implements UserService {

    private UserRepository userRepository;
    private MessageDigest coder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        try{
            coder = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public User create(UserRegistrationDTO form) {
        String password = form.getPassword();
        coder.update(password.getBytes(), 0, password.length());
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BigInteger(1, coder.digest()).toString(16));
//        user.setRole(form.getRole());
        return userRepository.save(user);
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User create() {
        return new User();
    }
}
