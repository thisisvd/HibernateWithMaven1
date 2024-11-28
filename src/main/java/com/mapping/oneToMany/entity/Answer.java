package com.mapping.oneToMany.entity;

import jakarta.persistence.*;

@Entity(name = "answer_many")
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int answerId;

    @Column(name = "answer_desc")
    private String answer;

    // @ManyToOne : this column will contain the question_id from table 1
    // This is an example of bidirectional mapping
    @ManyToOne
    private Question question;

    public Answer() {}

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}