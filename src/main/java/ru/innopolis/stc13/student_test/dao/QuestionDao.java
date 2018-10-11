package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.stc13.student_test.pojo.Question;

public interface QuestionDao extends CrudRepository<Question, Integer> {
}
