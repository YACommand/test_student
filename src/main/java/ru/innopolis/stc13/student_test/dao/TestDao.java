package ru.innopolis.stc13.student_test.dao;

import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.List;

public interface TestDao {

    boolean add(Test test);

    Test get(Integer id);

    boolean update(Test test);

    boolean delete(Integer id);

    List<Test> getAll();
}
