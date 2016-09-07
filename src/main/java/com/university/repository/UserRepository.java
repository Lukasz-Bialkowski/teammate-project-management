package com.university.repository;

import com.university.crud.CrudfsRepository;
import com.university.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudfsRepository<User> {

    Optional<User> findOneByEmail(String email);

}
