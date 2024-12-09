package com.cascade.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "questions_cascade")
public class Question {

    @Id
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question_desc")
    private String question;

    // @OneToMany : In this class this annotation will create another class to store
    // question_id & answer_id to keep track of.
    // If other table doesn't use ManyToOne then it's a unidirectional mapping
    // @OneToMany(mappedBy = "question") : here using mappedBy will not create another table for it
    // @OneToMany(mappedBy = "question")
    // @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Answer> answer;
    // cascade : Will save this & related table automatically, no need to save via persist
    // CascadeType.ALL : Will perform all operation like add, update, delete that table value
    // CascadeType.PERSIST : Will add value in linked table when the main table is deleted
    // CascadeType.REMOVE : Will remove from linked table when the main table is deleted

    public Question() {}

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public List<Answer> getAnswer() {
        return answer;
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
}
