package com.mapping.oneToOne;

import com.mapping.oneToOne.entity.Answer;
import com.mapping.oneToOne.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) throws Exception {

        // init and opening sessions
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // creating object
        Question q1 = new Question();
        q1.setQuestionId(101);
        q1.setQuestion("This is question number 1");
        Answer a1 = new Answer();
        a1.setAnswerId(1001);
        a1.setAnswer("Answer 1");
        a1.setQuestion(q1);
        q1.setAnswer(a1);

        Question q2 = new Question();
        q2.setQuestionId(121);
        q2.setQuestion("This is question number 2222");
        Answer a2 = new Answer();
        a2.setAnswerId(1022);
        a2.setAnswer("Answer 222");
        a2.setQuestion(q2);
        q2.setAnswer(a2);

        // getting current session
        Session session = sessionFactory.openSession();

        // starting transaction
        Transaction transaction = session.beginTransaction();

        // save object
        session.persist(a1);
        session.persist(a2);
        session.persist(q1);
        session.persist(q2);

        // commiting all in db
        transaction.commit();

        // closing session factory
        sessionFactory.close();
    }
}
