package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "specialization")
public class Specialization {
    @Id
    private Integer id;
    private String name;

    public Specialization() {
    }

    public Specialization(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
