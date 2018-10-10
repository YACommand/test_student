package ru.innopolis.stc13.student_test.pojo;

import java.util.Objects;

public class Teacher extends User {

    private String specialization;

    public Teacher(){}

    @Override
    public String toString() {
        return "Teacher{" +
                "specialization='" + specialization + '\'' +
                '}';
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Teacher(int id, String login, String password, String name, String specialization) {
        super(id, login, password, name);
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(specialization, teacher.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialization);
    }
}
