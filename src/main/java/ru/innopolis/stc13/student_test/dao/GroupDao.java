package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.stc13.student_test.pojo.Group;

import java.util.List;

public interface GroupDao extends JpaRepository<Group, Integer> {
    List<Group> getByNumber(Integer number);
}
