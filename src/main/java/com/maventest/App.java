package com.maventest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
//        System.out.println("Project Started!");
//        // Connection used for sessions objects
//        // There should be only 1 session in 1 project
//        // The below code fill find the file hibernate.cfg.xml file and add accordingly
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        // SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml).buildSessionFactory();
//        System.out.println(sessionFactory);
//        System.out.println(sessionFactory.isClosed());

        // Adding user
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Open a session first then we can use currentSession() object
        Session session = sessionFactory.openSession();
        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // User object
        Users user = new Users();
        user.setUserName("Jorge Smith");
        user.setUserEmail("smith@email.com");
        user.setAddress("St. 458, South Avenue, Melbourne, Australia");

        // save in database
        // make table if not exist, enter data etc
        session.persist(user);

        // After successful query commit to db
        transaction.commit();
        // Close session
        session.close();
    }
}