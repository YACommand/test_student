package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.innopolis.stc13.student_test.pojo.Test;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.List;

public interface TestDao extends JpaRepository<Test, Integer>{

    @Query(value = "select * from tests\n" +
                    "left join groups_tests groups\n" +
                    "      on tests.id = groups.test_id\n" +
                    "where group_id = (select group_id from user_group where user_id = :id)",
            nativeQuery = true)
    List<Test> getByUser(@Param("id") int id);
}
