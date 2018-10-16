package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.SpecializationDao;
import ru.innopolis.stc13.student_test.pojo.Specialization;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    private SpecializationDao specializationDao;

    @Autowired
    public void setSpecializationDao(SpecializationDao specializationDao) {
        this.specializationDao = specializationDao;
    }

    @Override
    public List<Specialization> getAll() {
        return specializationDao.findAll();
    }

    @Override
    public boolean update(Specialization specialization) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Specialization get(Integer id) {
        if (id != null) {
            return specializationDao.getOne(id);
        }
        return null;
    }
}
