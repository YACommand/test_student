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

import java.util.List;

import static org.junit.Assert.*;
import static ru.innopolis.stc13.student_test.TestTestData.*;

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@SpringBootTest
public class TestServiceImplTest {

    @TestConfiguration
    static class TestServiceImplTestContextConfiguration {

        @Bean
        public TestService testService() {
            return new TestServiceImpl();
        }
    }

    @Autowired
    private TestService testService;

    @Test
    public void delete() {
        assertTrue(testService.delete(1));
//        testService.delete(1);
//        assertMatch(testService.getAll(), Arrays.asList(TEST2, TEST3));
    }

    @Test
    public void deleteNotFound() {
        assertFalse(testService.delete(5));
    }

    @Test
    public void add() {
        testService.add(TEST4);
        assertMatch(testService.getAll(), TEST4, TEST3, TEST2, TEST1);
    }

    @Test
    public void get() {
        ru.innopolis.stc13.student_test.pojo.Test actual = testService.get(2);
        assertNotNull(actual);
//        assertMatch(actual, TEST2);
    }

    @Test
    public void getNotFound() {
        ru.innopolis.stc13.student_test.pojo.Test actual = testService.get(5);
        assertNull(actual);
    }

    @Test
    public void update() {
        testService.update(TEST1_UPDATED);
        assertMatch(testService.get(1), TEST1_UPDATED);
    }

    @Test
    public void updateNotFound() {
        assertFalse(testService.update(TEST5));
    }

    @Test
    public void getAll() {
//        assertMatch(testService.getAll(),TESTS);
        List<ru.innopolis.stc13.student_test.pojo.Test> list = testService.getAll();
        assertEquals(list.size(), 3);
    }
}
