package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;

@Entity(name = "groups")
public class Group {
    @Id
    private Integer id;
    private String name;
    @Column(name = "internal")
    private boolean isInternal;
    private int number;
    @ManyToMany(mappedBy = "groups")
    private List<Test> tests;

    public Group() {
    }

    public Group(int id, String name, boolean isInternal, int number) {
        this.id = id;
        this.name = name;
        this.isInternal = isInternal;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInternal() {
        return isInternal;
    }

    public void setInternal(boolean internal) {
        isInternal = internal;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isInternal=" + isInternal +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                isInternal == group.isInternal &&
                number == group.number &&
                Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isInternal, number);
    }
}
