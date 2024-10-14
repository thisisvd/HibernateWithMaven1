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

        UserOrder order = session.load(UserOrder.class, 2);
        System.out.println("load() : " + order.toString());

        // close all components
        session.close();
        sessionFactory.close();
    }
}
