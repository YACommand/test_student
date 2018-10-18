package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "answers")
public class Answer implements Serializable {

    @Id
    private Integer id;

    @Column(name = "text")
    private String content;

    private Boolean correct;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    public Answer(String content, Boolean correct) {
        this.content = content;
        this.correct = correct;
    }

    public Answer(Integer id, String content, Boolean correct, Question question) {
        this.id = id;
        this.content = content;
        this.correct = correct;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}