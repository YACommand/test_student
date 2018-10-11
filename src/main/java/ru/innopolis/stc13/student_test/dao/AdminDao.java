package ru.innopolis.stc13.student_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.innopolis.stc13.student_test.pojo.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer> {
}