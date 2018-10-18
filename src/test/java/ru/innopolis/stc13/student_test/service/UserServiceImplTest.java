package ru.innopolis.stc13.student_test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static ru.innopolis.stc13.student_test.UserTestData.*;

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@SpringBootTest
@Transactional
public class UserServiceImplTest {

    @TestConfiguration
    static class TestServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void delete() {
        userService.delete(1);
        assertMatch(userService.getAll(), Arrays.asList(TEACHER2, STUDENT, ADMIN));
    }

    @Test
    public void deleteNotFound() {
        assertFalse(userService.delete(5));
    }

    @Test
    public void add() {
        userService.add(TEACHER3);
        assertMatch(userService.getAll(), TEACHER1, TEACHER2, STUDENT, ADMIN, TEACHER3);
    }

    @Test
    public void get() {
        User actual = userService.get(1);
        assertMatch(actual, TEACHER1);
    }

    @Test
    public void getNotFound() {
        User actual = userService.get(6);
        assertNull(actual);
    }

    @Test
    public void update() {
        userService.update(TEACHER2_UPDATED);
        assertMatch(userService.get(2), TEACHER2_UPDATED);
    }

    @Test
    public void updateNotFound() {
        assertFalse(userService.update(TEACHER4));
    }

    @Test
    public void getAll() {
        assertMatch(userService.getAll(), USERS);
    }
}
