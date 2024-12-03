package com.states;

import com.states.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StatesDemo {

    public static void main(String[] args) throws Exception {

        // Hibernate/Persistence lifecycle States
        // Transient
        // Persistent
        // Detached
        // Removed

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Creating obj [Transient State]
        // obj isn't associated with db or session
        Student student = new Student();
        student.setId(1122);
        student.setStudentName("Helen Jake");
        student.setAddress("New YorkCity, New York, USA");

        // [Persistent State]
        // Obj is associate with session as well as db also
        // In this state changes will also be reflected in db on updation
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        // same obj value is updated here
        student.setStudentName("Kelly bottom");
        // commit values
        transaction.commit();

        // [Removed State]
        // value will be removed from db, but still associated with session
        // first get() the vale from db and then call delete() or remove()
        // session.remove();

        // [Detached State]
        // obj is not associated with session anymore
        session.close();        // session.clear();
        // obj value will not be updated as session is closed
        student.setStudentName("Amy Santiago");

        sessionFactory.close();
    }
}
