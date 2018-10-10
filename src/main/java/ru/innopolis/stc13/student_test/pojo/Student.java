package ru.innopolis.stc13.student_test.pojo;

import java.security.acl.Group;
import java.util.Objects;

public class Student extends User {

    private Group group;

    public Student(int id, String login, String password, String name, Group group) {
        super(id, login, password, name);
        this.group = group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    //TODO узнать про поля суперкласса в equals, hashcode и toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "group=" + group +
                '}';
    }

}