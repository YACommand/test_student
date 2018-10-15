package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.TeacherDao;
import ru.innopolis.stc13.student_test.dao.UserDao;
import ru.innopolis.stc13.student_test.pojo.Teacher;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private UserDao userDao;
    private TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean add(Teacher teacher) {
        if (teacher == null) {
            return false;
        } else if (userDao.getByLogin(teacher.getLogin()) != null) {
            return false;
        }
        return teacherDao.save(teacher) != null;
    }

    @Override
    public Teacher get(Integer id) {
        if (id == null) {
            return null;
        }
        return teacherDao.getOne(id);
    }

    @Override
    public boolean update(Teacher teacher) {
        if (teacher == null || teacher.getId() == null) {
            return false;
        } else {
            return teacherDao.save(teacher) != null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if (this.get(id) != null) {
            teacherDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.findAll();
    }

    @Override
    public boolean isUserExist(Teacher teacher) {
        if (teacher == null) {
            return false;
        } else {
            return teacher.getId() != null && userDao.getOne(teacher.getId()) != null;
        }
    }
}
