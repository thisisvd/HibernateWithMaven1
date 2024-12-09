package com.criteriaapi;

import com.states.entity.Student;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CriteriaApiDemo {

    public static void main(String[] args) {

        // Docs : https://www.baeldung.com/hibernate-criteria-queries

        // init session factory and open sessions
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        // being a transaction
        Transaction transaction = session.beginTransaction();


        // Create an instance of CriteriaBuilder by calling the getCriteriaBuilder() method
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        // Create an instance of CriteriaQuery by calling the CriteriaBuilder createQuery() method
        CriteriaQuery cq = criteriaBuilder.createQuery(Student.class);

        // addding root
        Root<Student> root = cq.from(Student.class);
        // cq.select(root);

        // adding restrictions
        // cq.select(root).where(criteriaBuilder.like(root.get("studentName"), "%Student 150%"));
        cq.select(root).where(criteriaBuilder.greaterThan(root.get("id"), 145));

        // normal query call
        Query query = session.createQuery(cq);
        List<Student> studentList = query.getResultList();
        for (Student p : studentList) {
            System.out.println(p.getStudentName() + " : " + p.getAddress());
        }

        // commit changes
        transaction.commit();
        // closing sessions
        session.close();
        sessionFactory.close();
    }
}
