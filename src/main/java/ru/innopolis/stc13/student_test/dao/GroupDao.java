package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.innopolis.stc13.student_test.pojo.Group;

import java.util.List;

public interface GroupDao extends CrudRepository<Group, Integer>{
}
