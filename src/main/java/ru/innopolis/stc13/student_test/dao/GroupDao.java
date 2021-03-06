package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.List;

public interface GroupDao extends JpaRepository<Group, Integer> {
    Group getByNumber(Integer number);

    Group getById(Integer id);

    List<Group> getByTests(Test test);
}
