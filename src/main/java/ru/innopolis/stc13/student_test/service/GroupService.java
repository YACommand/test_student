package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.Group;

import java.util.List;

public interface GroupService {

    boolean add(Group group);

    Group get(Integer id);

    boolean update(Group group);

    boolean delete(Integer id);

    List<Group> getAll();

    boolean isGroupExist(Group group);

    boolean validate(Group group);

    boolean isNumberExist(Group group);

    boolean checkAddNumber(Group group);

}
