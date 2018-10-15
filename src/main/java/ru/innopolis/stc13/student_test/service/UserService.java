package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.User;
import java.util.List;

public interface UserService {

    boolean add(User user);

    User get(Integer id);

    boolean update(User user);

    boolean delete(Integer id);

    List<User> getAll();

    boolean isUserExist(User user);

    List<User> getAllByRole(User user);

    List<User> getRoleById(Integer id);

}
