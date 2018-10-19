package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.LAZY)
    private Set<Answer> answers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    public Question() {
    }

    public Question(Integer id, String text, Set<Answer> answers, Test test) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.test = test;
    }

    public Question(Integer id, String text, Set<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }

    public Question(String text, Set<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(text, question.text) &&
                Objects.equals(answers, question.answers)
//                && Objects.equals(test, question.test)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, answers
//                , test
        );
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answers=" + answers +
//                ", test=" + test +
                '}';
    }
}
