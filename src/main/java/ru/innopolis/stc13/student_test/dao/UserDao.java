package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.stc13.student_test.pojo.User;

public interface UserDao extends JpaRepository<User, Integer> {
    User getByLogin(String login);
}
