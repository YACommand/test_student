package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Question;
import ru.innopolis.stc13.student_test.pojo.Test;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.List;
import java.util.Map;

public interface TestService {

    Test add(Test test);

    Test get(Integer id);

    boolean updateQuestion(Map<String, String> params, String[] answerId);

    boolean updateDescription(String id, String description);

    public boolean update(Test test);

    boolean delete(Integer id);

    List<Test> getAll();

    Question addQuestion(Question question);

    boolean deleteQuestion(Integer id);

    List<Test> getByUser(Integer id);

    List<Test> getTestByUserId(Integer userId);

    boolean assignmentGroupForTest(Integer testId, String[] groupsId);

    boolean assignmentTestForGroup(Integer groupId, String[] testsId);
    }
