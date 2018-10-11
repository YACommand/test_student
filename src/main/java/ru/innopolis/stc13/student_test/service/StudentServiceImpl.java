package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.StudentDao;
import ru.innopolis.stc13.student_test.pojo.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public boolean add(Student student) {
        if (student != null) {
            studentDao.save(student);
            return true;
        }
        return false;
    }

    @Override
    public Student get(Integer id) {
        return studentDao.getOne(id);
    }

    @Override
    public boolean update(Student student) {
        if (student != null) {
            this.add(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (this.get(id) != null) {
            studentDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }
}
