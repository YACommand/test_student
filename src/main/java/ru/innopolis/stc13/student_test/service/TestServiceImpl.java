package ru.innopolis.stc13.student_test.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc13.student_test.dao.*;
import ru.innopolis.stc13.student_test.pojo.Answer;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Question;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.*;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupDao groupDao;

    final static Logger LOGGER = Logger.getLogger(UserService.class);

    @Override
    public Test add(Test test) {
        if (test != null && test.getId() == null) {
            LOGGER.info("has been added test" + test.toString());
            return testDao.save(test);
        }
        LOGGER.info("has been added test" + test.toString());
        return null;
    }

    @Override
    public Test get(Integer id) {
        if (id != null && testDao.existsById(id)) {
            return testDao.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public boolean update(Test test) {
        if (test != null && testDao.existsById(test.getId())) {
            return testDao.save(test) != null;
        }
        return false;
    }

    @Override
    public boolean updateDescription(String id, String description) {
        if (id == null || description == null) {
            return false;
        }
        Integer testId = Integer.parseInt(id);
        if (testDao.existsById(testId)) {
            Test test = testDao.findById(testId).orElse(null);
            if (test != null) {
                test.setDescription(description);
                return testDao.save(test) != null;
            }
        }
        return false;
    }

    public Question addQuestion(Question question) {
        if (question != null) {
            return questionDao.save(question);
        }
        return null;
    }

    @Override
    public boolean deleteQuestion(Integer id) {
        if (id != null) {
            questionDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Test> getByUser(Integer id) {
        if (id != null && userDao.existsById(id)) {
            return testDao.getByUser(id);
        }
        return Collections.emptyList();
    }

    public List<Test> getTestByUserId(Integer userId) {
        return testDao.getTestByTeacherId(userId);
    }

    @Override
    public boolean assignmentGroupForTest(Integer testId, String[] groupsId) {
        if (groupsId != null && testId != null) {
            Set<Group> groupSet = new HashSet<>();
            for (String id : groupsId) {
                if (id != null) {
                    int groupIntId = Integer.parseInt(id);
                    groupSet.add(groupDao.getById(groupIntId));
                }
            }
            Test test = testDao.getById(testId);
            if (test != null) {
                test.setGroups(groupSet);
                testDao.save(test);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean assignmentTestForGroup(Integer groupId, String[] testsId) {
        if (groupId != null && testsId != null) {
            Set<Test> testSet = new HashSet<>();
            for (String id : testsId) {
                if (id != null) {
                    int testIntId = Integer.parseInt(id);
                    testSet.add(testDao.getById(testIntId));
                }
            }
            Group group = groupDao.getById(groupId);
            if (group != null) {
                group.setTests(testSet);
                groupDao.save(group);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateQuestion(Map<String, String> params, String[] answerId) {
        if (params == null || answerId == null) {
            return false;
        }
        Question question;
        String strQuestionId = params.get("questionId");
        String questionText = params.get("text");
        Integer questionId = Integer.parseInt(strQuestionId);
        if (questionText == null) {
            return false;
        }
        question = questionDao.findById(questionId).orElse(null);
        if (question == null) {
            return false;
        }
        question.setText(questionText);
        Set<Answer> answers = new HashSet<>();
        for (String id : answerId) {
            answers.add(new Answer(Integer.parseInt(id),
                    params.get("content" + id),
                    Boolean.parseBoolean(params.get("correct" + id)),
                    question));
        }
        String newAnswerContent = params.get("contentNew");
        if (!"".equals(newAnswerContent)) {
            Answer newAnswer = answerDao.save(new Answer(null,
                    newAnswerContent,
                    Boolean.parseBoolean(params.get("correctNew")),
                    question));
            answers.add(newAnswer);
        }
        question.setAnswers(answers);
        return questionDao.save(question) != null;
    }

    @Override
    public boolean delete(Integer id) {
        if (id != null && testDao.existsById(id)) {
            testDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Test> getAll() {
        return testDao.findAll();
    }
}
