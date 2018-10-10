package ru.innopolis.stc13.student_test.dao;

import ru.innopolis.stc13.student_test.pojo.Group;

import java.util.List;

public interface GroupDao {

    boolean add(Group group);

    Group getById(Integer id);

    boolean update(Group group);

    boolean deleteById(Integer id);

    List<Group> getAll();
}
