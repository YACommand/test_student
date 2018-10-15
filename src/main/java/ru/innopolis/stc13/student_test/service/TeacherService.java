package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    boolean add(Teacher teacher);

    Teacher get(Integer id);

    boolean update(Teacher teacher);

    boolean delete(Integer id);

    List<Teacher> getAll();

    boolean isUserExist(Teacher teacher);
}
