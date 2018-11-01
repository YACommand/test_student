package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.TestResultDao;
import ru.innopolis.stc13.student_test.dao.UserDao;
import ru.innopolis.stc13.student_test.pojo.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class TestResultServiceImpl implements TestResultService {

    @Autowired
    private TestService testService;

    @Autowired
    private TestResultDao testResultDao;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean add(TestResult testResult) {
        if (testResult != null && testResult.getId() == null) {
            return testResultDao.save(testResult) != null;
        }
        return false;
    }

    @Override
    public TestResult get(Integer id) {
        if (id != null && testResultDao.existsById(id)) {
            return testResultDao.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public boolean update(TestResult testResult) {
        if (testResult != null && testResultDao.existsById(testResult.getId())) {
            return testResultDao.save(testResult) != null;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (id != null && testResultDao.existsById(id)) {
            testResultDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TestResult> getAll() {
        return testResultDao.findAll();
    }

    @Override
    public int process(Map<String, String> parameters, User user) {
        Test test = testService.get(Integer.parseInt(parameters.get("id")));
        int totalCount = test.getQuestions().size();
        int checkedAnswerId;
        int rightAnswerCount = 0;
        for (Question question : test.getQuestions()) {
            checkedAnswerId = Integer.parseInt(parameters.get("answer" + question.getId()));
            for (Answer answer : question.getAnswers()) {
                if (answer.isCorrect()) {
                    if (checkedAnswerId == answer.getId()) {
                        rightAnswerCount++;
                    }
                }
            }
        }
        int score = (int) (rightAnswerCount / (double) totalCount * 100);
        add(new TestResult(test, user, score));
        return score;
    }

    @Override
    public List<TestResult> getByUser(Integer id) {
        if (id != null && userDao.existsById(id)) {
            return testResultDao.getByUser(id);
        }
        return Collections.emptyList();
    }
}
