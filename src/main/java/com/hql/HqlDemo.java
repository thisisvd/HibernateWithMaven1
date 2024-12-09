package com.hql;

import com.states.entity.Student;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class HqlDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL : Hibernate Query Language
        // String hqlQuery = "FROM Student WHERE address = 'Los Angeles, California, USA'";
        // Query q = session.createQuery(hqlQuery);

        // query using var x
        // String hqlQuery = "FROM Student WHERE address=:x";
        // Query q = session.createQuery(hqlQuery);
        // q.setParameter("x", "Los Angeles, California, USA");

        // query using alias
        String hqlQuery = "FROM Student as s WHERE s.address=:x AND s.studentName=:n";
        Query q = session.createQuery(hqlQuery);
        q.setParameter("x", "Los Angeles, California, USA");
        q.setParameter("n", "Allen paul");

        // 2 types of return :
        // Single value : (Unique)
        // List of values : Multiple values

        List<Student> studentList = q.getResultList();

        for (Student student : studentList) {
            System.out.println(student);
        }

        System.out.println("----------------------------------------------------");

        // Delete query
        /*
        hqlQuery = "delete from Student AS s WHERE s.studentName=:n";
        Query delQuery = session.createQuery(hqlQuery);
        delQuery.setParameter("n", "Allen paul");

        // executeUpdate : returns the value of rows affected
        int rowsAffected  = delQuery.executeUpdate();
        System.out.println("Deleted Rows : " + rowsAffected);
        */

        // Update query
        /*
        hqlQuery = "UPDATE Student AS s SET s.address=:city WHERE s.studentName=:n";
        Query updateQuery = session.createQuery(hqlQuery);
        updateQuery.setParameter("city", "Chicago, USA");
        updateQuery.setParameter("n", "Helen Jake");

        // executeUpdate : returns the value of rows affected
        int rowsAffected  = updateQuery.executeUpdate();
        System.out.println("Updated Rows : " + rowsAffected);
        */

        // Join Query
        // Example : Question & Answer vala example
        hqlQuery = "SELECT q.questionId, q.question, a.answer FROM questions as q" +
                " INNER JOIN q.answer as a " +
                " WHERE a.answerId=:id";
        Query joinQuery = session.createQuery(hqlQuery);
        joinQuery.setParameter("id", "1001");

        List<Object[]> list = joinQuery.getResultList();
        for (Object[] o : list) {
            System.out.println(Arrays.toString(o));
        }

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}