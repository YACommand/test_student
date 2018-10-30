package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.List;

public interface TestDao extends JpaRepository<Test, Integer>{

    List<Test> getTestByTeacherId(Integer id);
}
