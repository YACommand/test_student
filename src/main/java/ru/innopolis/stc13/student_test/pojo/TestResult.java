package ru.innopolis.stc13.student_test.pojo;

import java.util.Objects;

public class TestResult {

    private int id;
    private Student student;
    private String grade;

    public TestResult() {
    }

    public TestResult(int id, Student student, String grade) {
        this.id = id;
        this.student = student;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", student=" + student +
                ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResult that = (TestResult) o;
        return id == that.id &&
                Objects.equals(student, that.student) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, grade);
    }
}
