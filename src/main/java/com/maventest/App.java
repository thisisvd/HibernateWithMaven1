package com.maventest;

import com.maventest.entity.UserOrder;
import com.maventest.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {

    public static void main(String[] args) throws IOException {
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

        // Open a session first, then we can use currentSession() object
        Session session = sessionFactory.openSession();
        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // User object
        Users user = new Users();
        user.setUserName("Nikki Minaj");
        user.setUserEmail("minaj@email.com");
        user.setAddress("St. Street, Manhattan, New York, USA");

        // save in database
        // make table if not exist, enter data etc
        session.persist(user);

        // User Order Object
        UserOrder order = new UserOrder();
        order.setOrderName("Iphone 15 Plus");
        order.setPrice(68000.00d);
        order.setQuantity(1);
        order.setInOffer(false);
        order.setOrderCreated(new Date());

        // Image path
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/image.png");
        byte[] imageBytes = new byte[fileInputStream.available()];
        fileInputStream.read(imageBytes);
        order.setOrderImage(imageBytes);

        // save in database
        // make table if not exist, enter data etc
        session.persist(order);

        // After successful query commit to db
        transaction.commit();
        // Close session
        session.close();
        sessionFactory.close();
    }
}