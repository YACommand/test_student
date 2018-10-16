package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.pojo.Specialization;

import java.util.List;

public interface SpecializationService {
    List<Specialization> getAll();

    boolean update(Specialization specialization);

    boolean delete(Integer id);

    Specialization get(Integer id);
}
