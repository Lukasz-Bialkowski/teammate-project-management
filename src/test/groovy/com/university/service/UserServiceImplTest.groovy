package com.university.service

import com.university.repository.UserRepository
import com.university.service.impl.UserServiceImpl
import spock.lang.Specification

class UserServiceImplTest extends Specification {

    UserRepository userRepositoryMock
    EmailSenderService emailSender
    UserService userService

    def setup () {
        userRepositoryMock = Mock(UserRepository)
        emailSender = Mock(EmailSenderService)
        userService = new UserServiceImpl(userRepositoryMock, emailSender)
    }

    def "persisted user should have same password after decoding" () {
//        given:
//        UserRegistrationDTO form = new UserRegistrationDTO();
//        form.setEmail("damian.kowalski@gmail.com")
//        form.setPassword("password")
//        form.setPasswordRepeated("password")
//
//        when:
//        User createdUser = userService.create(form)
//
//        then:
//        1 * userRepositoryMock.save(_ as User) >> { User user -> user }
//        assert new String(Base64.getDecoder().decode( createdUser.getPasswordHash() ), StandardCharsets.UTF_8 ) == form.getPassword()
    }

}
