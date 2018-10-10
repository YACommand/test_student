package ru.innopolis.stc13.student_test.pojo;

import java.util.Map;
import java.util.Objects;

public class Question {

    private int id;
    private String text;
    private Map<String, Boolean> answers;

    public Question() {
    }

    public Question(int id, String text, Map<String, Boolean> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
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

    public Map<String, Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Boolean> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                Objects.equals(text, question.text) &&
                Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, answers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}
