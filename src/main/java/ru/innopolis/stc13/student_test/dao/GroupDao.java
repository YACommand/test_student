package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.stc13.student_test.pojo.Group;

public interface GroupDao extends JpaRepository<Group, Integer> {
    Group getByNumber(Integer number);

    Group getById(Integer id);
}
