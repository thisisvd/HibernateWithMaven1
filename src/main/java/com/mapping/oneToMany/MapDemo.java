package com.mapping.oneToMany;

import com.mapping.oneToMany.entity.Answer;
import com.mapping.oneToMany.entity.Question;
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
//        Question q1 = new Question();
//        q1.setQuestionId(101);
//        q1.setQuestion("This is question number 1");
//
//        // answer 1
//        Answer a1 = new Answer();
//        a1.setAnswerId(1001);
//        a1.setAnswer("Answer 1");
//        a1.setQuestion(q1);
//
//        // answer 2
//        Answer a2 = new Answer();
//        a2.setAnswerId(1002);
//        a2.setAnswer("Answer 2");
//        a2.setQuestion(q1);
//
//        List<Answer> answerList = new ArrayList<>();
//        answerList.add(a1);
//        answerList.add(a2);
//        q1.setAnswer(answerList);

        // getting current session
        Session session = sessionFactory.openSession();

        // starting transaction
        Transaction transaction = session.beginTransaction();

        // save object
//        session.persist(a1);
//        session.persist(a2);
//        session.persist(q1);

//        // fetching that object
//        Question question = session.getReference(Question.class, 101);
//        System.out.println(question);
//        for (Answer answer : question.getAnswer()) {
//            System.out.println(answer.getAnswerId() + " : " + answer.getAnswer());
//        }

        // Fetching types
        // Lazy & Eager
        // We have to define the type in after @OneToMany(fetch = FetchType.EAGER or FetchType.LAZY)
        // Lazy : It will load associated child object when they are actually called, not will only parent object is called.
        // Eager : It will load all the objects when the parent object is called.
        Question question = session.get(Question.class, 101);
        System.out.println(question.getQuestionId() + " : " + question.getQuestion());
        // In LAZY, So when the below list is called then another query will be run to fetch the data from db
        System.out.println(question.getAnswer());

        // In EAGER, all query associated with all child objects will be loaded
        // so, Question question = session.get(Question.class, 101); will load all data

        // commiting all in db
        transaction.commit();

        // closing session factory
        sessionFactory.close();
    }
}
