package com.maventest;

import com.maventest.entity.UserOrder;
import com.maventest.entity.Users;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class FetchData {

    public static void main(String[] args) throws IOException {

        // get(), load()
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // open a session
        Session session = sessionFactory.openSession();

        Users user = session.get(Users.class, 1);
        System.out.println("get() : " + user.toString());

        // for null values
        // Users user1 = session.get(Users.class, 11);
        // will not call 2 sql queries for same id will fetch data from cache
        // Users user1 = session.get(Users.class, 1);
        // the below line will also call the sql query
        Users user1 = session.get(Users.class, 2);
        System.out.println("get() : " + user1.toString());

        // load() is deprecated so use getReference
        // UserOrder order = session.load(UserOrder.class, 2);
        UserOrder order = session.getReference(UserOrder.class, 2);
        // the above line will not call sql query
        // UserOrder order = session.getReference(UserOrder.class, 22);

        // When the below object is called sql query is called
        System.out.println("load() : " + order.toString());

        // close all components
        session.close();
        sessionFactory.close();
    }
}
