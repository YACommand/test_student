package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.List;

public interface UserService {

    boolean add(User user);

    User get(Integer id);

    boolean update(User user);

    boolean delete(Integer id);

    List<User> getAll();

    boolean isUserExist(User user);

    List<User> getAllByRole(Role role);

    boolean validate(User user);

    User getByLogin(String login);

    List<User> getByGroup(Group group);

    boolean updatePassword(Integer id, String password);
}
