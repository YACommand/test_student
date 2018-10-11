package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.stc13.student_test.pojo.Group;

public interface GroupDao extends CrudRepository<Group, Integer>{
}
