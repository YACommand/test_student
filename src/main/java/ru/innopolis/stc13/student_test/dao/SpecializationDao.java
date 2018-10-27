package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.stc13.student_test.pojo.Specialization;

public interface SpecializationDao extends JpaRepository<Specialization, Integer> {


}
