package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "answers")
public class Answer implements Serializable {

    @Id
    private Integer id;

    @Column(name = "text")
    private String content;

    private Boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
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

    public Answer(Integer id, String content, Boolean correct) {
        this.id = id;
        this.content = content;
        this.correct = correct;
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

    public Boolean isCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) &&
                Objects.equals(content, answer.content) &&
                Objects.equals(correct, answer.correct)
//                && Objects.equals(question, answer.question)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, correct
//                , question
        );
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + content + '\'' +
                ", isCorrect=" + correct +
//                ", question=" + question +
                '}';
    }
}