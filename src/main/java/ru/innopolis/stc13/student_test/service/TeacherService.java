package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.Teacher;

public interface TeacherService {

    boolean add(Teacher teacher);

    boolean get(Integer id);

    boolean update(Teacher teacher);

    boolean delete(Integer id);

    boolean getAll();
}
