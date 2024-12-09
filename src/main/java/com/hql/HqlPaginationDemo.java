package com.hql;

import com.states.entity.Student;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HqlPaginationDemo {

    public static void main(String[] args) throws Exception {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hqlQuery = "FROM Student";
        Query query = session.createQuery(hqlQuery);
        // starting result position : starts at index 0 : 1st row or nth row for value of n
        query.setFirstResult(15);
        // page size
        query.setMaxResults(10);

        List<Student> studentList = query.list();
        for (Student s : studentList) {
            System.out.println(s.getId() + " : " + s.getStudentName() + " : " + s.getAddress());
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
