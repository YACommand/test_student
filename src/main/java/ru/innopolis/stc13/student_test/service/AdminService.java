package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.Admin;

public interface AdminService {

    boolean add(Admin admin);

    boolean get(Integer id);

    boolean update(Admin admin);

    boolean delete(Integer id);

    boolean getAll();
}
