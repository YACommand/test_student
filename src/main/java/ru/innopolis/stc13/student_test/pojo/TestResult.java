package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "results")
public class TestResult {

    private Test test;
    private Student student;
    private Integer grade;

    public TestResult() {
    }

    public TestResult(Test test, Student student, Integer grade) {
        this.test = test;
        this.student = student;
        this.grade = grade;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResult that = (TestResult) o;
        return Objects.equals(test, that.test) &&
                Objects.equals(student, that.student) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(test, student, grade);
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "test=" + test +
                ", student=" + student +
                ", grade=" + grade +
                '}';
    }
}
