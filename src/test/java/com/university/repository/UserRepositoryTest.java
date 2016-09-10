package com.university.repository;

import com.university.TeammateApplication;
import com.university.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TeammateApplication.class)
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void setup() {
        System.out.println("Items in database: "+ userRepository.count());
    }

    @Test
    @Rollback(true)
    public void shouldPersistExaclyOneUserTest() {

        final String USER_MAIL= "damian.kowalski@gmail.com";
        User user = new User();
        user.setEmail(USER_MAIL);
        user.setPasswordHash("s0m3h4sh");

        userRepository.save(user);
        Optional<User> persistedUser = userRepository.findOneByEmail(USER_MAIL);

        persistedUser.ifPresent(u ->
                assertNotNull(u.getId()));
        assertTrue(persistedUser.isPresent());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldFailPersistingEntityWithNoMailTest() {

        final String USER_MAIL= "damian.kowalski@gmail.com";
        User user = new User();
        user.setEmail(USER_MAIL);

        userRepository.save(user);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldFailPersistingEntityWithNotUniqueMailTest() {

        final String USER_MAIL= "damian.kowalski@gmail.com";
        User user = new User();
        user.setEmail(USER_MAIL);
        user.setPasswordHash("s0m3h4sh");
        user.setId(4L);

        User user2 = new User();
        user2.setEmail(USER_MAIL);
        user2.setPasswordHash("s0m3h4sh");

        userRepository.save(Arrays.asList(user, user2));
    }

    @Test
    @Rollback(true)
    public void shouldPersistExactly2InstancesTest() {

        final String USER_MAIL = "damian.kowalski@gmail.com";
        final String USER_MAIL2 = "grzegorz.kowalski@gmail.com";

        User user = new User();
        user.setEmail(USER_MAIL);
        user.setPasswordHash("s0m3h4sh");
        user.setId(4L);

        User user2 = new User();
        user2.setId(4L);
        user2.setEmail(USER_MAIL2);
        user2.setPasswordHash("s0m3h4sh");

        userRepository.save(Arrays.asList(user, user2));
        assertEquals("Should be 2 entities stored ", 2, userRepository.findAll().size());
    }

}
