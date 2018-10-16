package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.TestDao;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

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
    public boolean delete(Integer id) {
        if (testDao.existsById(id)) {
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
