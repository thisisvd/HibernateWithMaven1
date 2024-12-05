package com.mapping.oneToOne.entity;

import jakarta.persistence.*;

@Entity(name = "answer")
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int answerId;

    @Column(name = "answer_desc")
    private String answer;

//    @OneToOne
//    @JoinColumn(name = "quest_id")
    @OneToOne(mappedBy = "answer")
    // here [mappedBy] means only answer class will be mapped so question column will not be formed
    // This class will not form any extra foreign key & will just create its personal columns
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