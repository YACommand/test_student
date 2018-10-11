package ru.innopolis.stc13.student_test.dao;

import ru.innopolis.stc13.student_test.pojo.Admin;

import java.util.List;

public interface AdminDao {

    boolean add(Admin admin);

    Admin get(Integer id);

    boolean update(Admin admin);

    boolean delete(Integer id);

    List<Admin> getAll();

}
