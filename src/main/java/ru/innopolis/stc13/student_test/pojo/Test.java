package ru.innopolis.stc13.student_test.pojo;

import java.util.List;
import java.util.Objects;

public class Test {

    int id;
    String description;
    Teacher teacher;
    List<Question> questions;
    List<Group> groups;

    public Test() {
    }

    public Test(int id, String description, Teacher teacher, List<Question> questions, List<Group> groups) {
        this.id = id;
        this.description = description;
        this.teacher = teacher;
        this.questions = questions;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return id == test.id &&
                Objects.equals(description, test.description) &&
                Objects.equals(teacher, test.teacher) &&
                Objects.equals(questions, test.questions) &&
                Objects.equals(groups, test.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, teacher, questions, groups);
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                ", questions=" + questions +
                ", groups=" + groups +
                '}';
    }
}
