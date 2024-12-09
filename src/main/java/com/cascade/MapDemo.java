package com.cascade;

import com.cascade.entity.Answer;
import com.cascade.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {

    public static void main(String[] args) throws Exception {

        // init and opening sessions
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // creating object
        Question q1 = new Question();
        q1.setQuestionId(101);
        q1.setQuestion("This is question number 1");

        // answer 1
        Answer a1 = new Answer();
        a1.setAnswerId(1001);
        a1.setAnswer("Answer 1");
        a1.setQuestion(q1);

        // answer 2
        Answer a2 = new Answer();
        a2.setAnswerId(1002);
        a2.setAnswer("Answer 2");
        a2.setQuestion(q1);

        // answer 3
        Answer a3 = new Answer();
        a3.setAnswerId(1003);
        a3.setAnswer("Answer 3");
        a3.setQuestion(q1);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(a1);
        answerList.add(a2);
        answerList.add(a3);
        q1.setAnswer(answerList);

        // getting current session
        Session session = sessionFactory.openSession();

        // starting transaction
        Transaction transaction = session.beginTransaction();

        // save object
//        session.persist(a1);
//        session.persist(a2);
//        session.persist(a3);
        // Added cascade in Answer type in Question
        // cascade : Will save this & related table automatically, no need to save via persist
        session.persist(q1);

        // commiting all in db
        transaction.commit();

        // closing session & session factory
        sessionFactory.close();
    }
}
