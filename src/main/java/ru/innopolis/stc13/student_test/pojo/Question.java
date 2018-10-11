package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.*;
import java.util.List;

//@Entity(name = "questions")
public class Question {

   // @Id
    private int id;
    private String text;

   // @OneToMany(mappedBy="question", fetch= FetchType.LAZY)
    private List<Answer> answers;

    //@ManyToOne
   // @JoinColumn(name = "test_id")
    private Test test;

    public Question() {
    }

    public Question(int id, String text, List<Answer> answers, Test test) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
