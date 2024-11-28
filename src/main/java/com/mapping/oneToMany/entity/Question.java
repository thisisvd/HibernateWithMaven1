package com.mapping.oneToMany.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "questions_many")
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
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Answer> answer;

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
