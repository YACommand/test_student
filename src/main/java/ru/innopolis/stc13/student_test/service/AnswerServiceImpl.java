package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.AnswerDao;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Override
    public boolean delete(Integer id) {
        if (id != null && answerDao.existsById(id)) {
            answerDao.deleteById(id);
            return true;
        }
        return false;
    }
}
