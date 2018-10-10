package ru.innopolis.stc13.student_test.dao;


import ru.innopolis.stc13.student_test.pojo.Student;

public interface StudentDao {

    boolean create(Student student);

    boolean read(Integer id);

    boolean update(Student student);

    boolean delete(Integer id);

    boolean getAll();

}
