package ru.innopolis.stc13.student_test.dao;

import ru.innopolis.stc13.student_test.pojo.Teacher;

public interface TeacherDao {

    boolean create(Teacher teacher);

    boolean read(Integer id);

    boolean update(Teacher teacher);

    boolean delete(Integer id);

    boolean getAll();

}
