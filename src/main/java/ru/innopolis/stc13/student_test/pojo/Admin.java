package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.*;

@Entity(name = "admin")
public class Admin extends User {
    private int test;

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}
