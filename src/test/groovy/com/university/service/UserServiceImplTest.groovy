package com.university.service

import com.university.entity.User
import com.university.entity.dto.UserRegistrationDTO
import com.university.repository.UserRepository
import com.university.service.impl.UserServiceImpl
import spock.lang.Specification

import java.nio.charset.StandardCharsets

class UserServiceImplTest extends Specification {

    UserRepository userRepositoryMock

    UserService userService

    def setup () {
        userRepositoryMock = Mock(UserRepository)
        userService = new UserServiceImpl(userRepositoryMock)
    }

    def "persisted user should have same password after decoding" () {
        given:
        UserRegistrationDTO form = new UserRegistrationDTO();
        form.setEmail("damian.kowalski@gmail.com")
        form.setPassword("password")
        form.setPasswordRepeated("password")

        when:
        User createdUser = userService.create(form)

        then:
        1 * userRepositoryMock.save(_ as User) >> { User user -> user }
        assert new String(Base64.getDecoder().decode( createdUser.getPasswordHash() ), StandardCharsets.UTF_8 ) == form.getPassword()
    }

}
