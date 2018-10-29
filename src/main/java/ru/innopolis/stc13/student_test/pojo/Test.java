package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User teacher;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", fetch = FetchType.EAGER)
    private Set<Question> questions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "groups_tests",
            joinColumns = {@JoinColumn(name = "test_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private Set<Group> groups;

    public Test() {
    }

    public Test(String description, User teacher, Set<Question> questions, Set<Group> groups) {
        this.description = description;
        this.teacher = teacher;
        this.questions = questions;
        this.groups = groups;
    }

    public Test(Integer id, String description, User teacher, Set<Question> questions, Set<Group> groups) {
        this.id = id;
        this.description = description;
        this.teacher = teacher;
        this.questions = questions;
    }

    public Test(String description, User teacher, Set<Question> questions) {
        this.description = description;
        this.teacher = teacher;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
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
