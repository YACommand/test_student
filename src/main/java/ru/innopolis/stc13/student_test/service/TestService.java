package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.List;

public interface TestService {

    boolean add(Test test);

    Test get(Integer id);

    boolean updateQuestion(Integer questionId,
                           String text,
                           Integer[] id,
                           String[] content,
                           Boolean[] correct);

    boolean update(Test test);

    boolean delete(Integer id);

    List<Test> getAll();

    boolean changeAnswerStatus(Integer answerId);
}
