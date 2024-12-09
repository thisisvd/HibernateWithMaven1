package com.sql;

import com.states.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class SqlDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String query = "SELECT * FROM Student";

        // Native Query
        NativeQuery nativeQuery = session.createNativeQuery(query);
        // We get user data as Objects array lists
        List<Object []> studentList = nativeQuery.list();

        for (Object[] s : studentList) {
//             System.out.println(Arrays.toString(s));
            System.out.println(s[0] + " : " + s[2]);
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
