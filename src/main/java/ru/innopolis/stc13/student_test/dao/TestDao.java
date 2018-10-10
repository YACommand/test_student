package ru.innopolis.stc13.student_test.dao;

import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.List;

public interface TestDao {

    boolean add(Test test);

    Test get(String id);

    boolean update(Test test);

    boolean delete(String id);

    List<Test> getAll();
}
