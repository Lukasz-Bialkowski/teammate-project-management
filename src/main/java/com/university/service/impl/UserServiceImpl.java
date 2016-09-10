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

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractCrudService<User> implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        final String encoded = Base64.getEncoder().encodeToString( form.getPassword().getBytes( StandardCharsets.UTF_8 ) );
//        final String decoded = new String(Base64.getDecoder().decode( encoded ), StandardCharsets.UTF_8 );
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(encoded);
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
