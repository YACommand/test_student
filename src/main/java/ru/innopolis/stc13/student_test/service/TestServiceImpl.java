package ru.innopolis.stc13.student_test.service;

import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.TestDao;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private TestDao testDao;

    @Override
    public boolean add(Test test) {
        if (test != null) {
            testDao.save(test);
            return true;
        }
        return false;
    }

    @Override
    public Test get(Integer id) {
        return testDao.getOne(id);
    }

    @Override
    public boolean update(Test test) {
        if (test != null) {
            add(test);
            return true;
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
