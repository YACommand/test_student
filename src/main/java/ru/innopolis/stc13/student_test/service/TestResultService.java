package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.TestResult;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.List;
import java.util.Map;

public interface TestResultService {

    boolean add(TestResult testResult);

    TestResult get(Integer id);

    boolean update(TestResult testResult);

    boolean delete(Integer id);

    List<TestResult> getAll();

    int process(Map<String,String> parameters, User user);

    List<TestResult> getByUser(Integer id);
}
