package ru.innopolis.stc13.student_test.dao;

import ru.innopolis.stc13.student_test.pojo.Admin;

public interface AdminDao {

    boolean add(Admin admin);

    Admin get(Integer id);

    boolean update(Admin admin);

    boolean delete(Integer id);

    Admin getAll();

}
