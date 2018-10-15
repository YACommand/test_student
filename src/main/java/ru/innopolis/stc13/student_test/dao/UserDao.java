package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User getByLogin(String login);

    List<User> getByRoles(Role role);

    List<User> getByGroups(Group group);
}
