package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.innopolis.stc13.student_test.pojo.TestResult;

import java.util.List;

public interface TestResultDao extends JpaRepository<TestResult, Integer> {

    @Query(value = "select * from results where user_id=:id", nativeQuery = true)
    List<TestResult> getByUser(@Param("id") int id);
}
