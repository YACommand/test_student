package ru.innopolis.stc13.student_test.dao;

import ru.innopolis.stc13.student_test.pojo.TestResult;

import java.util.List;

public interface TestResultDao {

    boolean add(TestResult testResult);

    TestResult getById(Integer id);

    boolean update(TestResult testResult);

    boolean deleteById(Integer id);

    List<TestResult> getAll();
}
