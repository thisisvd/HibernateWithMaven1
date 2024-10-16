package com.maventest;

import com.maventest.entity.UserOrder;
import com.maventest.entity.UserWishlist;
import com.maventest.entity.Users;
import com.maventest.entity.UsersEmbedded;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class AppEmbeddedDemo {

    public static void main(String[] args) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Open a session first then we can use currentSession() object
        Session session = sessionFactory.openSession();
        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // User object only made for embedded demo
        UsersEmbedded user = new UsersEmbedded();
        user.setUserName("Nikki Minaj");
        user.setUserEmail("minaj@email.com");
        user.setAddress("St. Street, Manhattan, New York, USA");
        UserWishlist userWishlist = new UserWishlist();
        userWishlist.setId("A9046W2");
        userWishlist.setName("Macbook pro");
        userWishlist.setInStock(true);
        user.setUserWishlist(userWishlist);

        // save in database
        // make table if not exist, enter data etc
        session.persist(user);

        // After successful query commit to db
        transaction.commit();
        // Close session
        session.close();
    }
}