package com.mapping.oneToOne.entity;

import jakarta.persistence.*;

@Entity(name = "questions")
public class Question {

    @Id
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question")
    private String question;

    // @OneToOne : This column takes the primary key of other table
    // as Foreign Key in this table.
    // @JoinColumn : used to updated properties of that column
    @OneToOne
    @JoinColumn(name = "ans_id")
    private Answer answer;

    public Question() {}

    public Question(int questionId, String question, Answer answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
