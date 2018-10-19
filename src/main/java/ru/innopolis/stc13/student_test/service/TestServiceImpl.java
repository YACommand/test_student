package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.AnswerDao;
import ru.innopolis.stc13.student_test.dao.QuestionDao;
import ru.innopolis.stc13.student_test.dao.TestDao;
import ru.innopolis.stc13.student_test.pojo.Answer;
import ru.innopolis.stc13.student_test.pojo.Question;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AnswerDao answerDao;

    @Override
    public boolean add(Test test) {
        if (test != null && test.getId() == null) {
            return testDao.save(test) != null;
        }
        return false;
    }

    @Override
    public Test get(Integer id) {
        if (id != null && testDao.existsById(id)) {
            return testDao.getOne(id);
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
    public boolean updateQuestion(Integer questionId, String text, Integer[] id, String[] content, Boolean[] correct) {
        if (questionId != null && text != null && id != null
                && content != null && correct != null) {
            Question question = questionDao.findById(questionId).orElse(null);
            if (question == null) {
                return false;
            }
            Set<Answer> answers = new HashSet<>();
            for (int i = 0; i < id.length; i++) {
                answers.add(new Answer(id[i], content[i], correct[i], question));
            }
            question.setAnswers(answers);
            question.setText(text);
            return questionDao.save(question) != null;
        }
        return false;
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

    @Override
    public boolean changeAnswerStatus(Integer answerId) {
        if (answerId != null) {
            Answer answer = answerDao.findById(answerId).orElse(null);
            if (answer != null) {
                answer.setCorrect(!answer.isCorrect());
                return answerDao.save(answer) != null;
            }
        }
        return false;
    }
}
