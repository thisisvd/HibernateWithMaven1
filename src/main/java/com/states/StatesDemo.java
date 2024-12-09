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
        Student student1 = new Student();
        student1.setId(1122);
        student1.setStudentName("Helen Jake");
        student1.setAddress("New York City, New York, USA");

        Student student2 = new Student();
        student2.setId(2233);
        student2.setStudentName("Amy Santiago");
        student2.setAddress("Phoenix, Arizona, USA");

        Student student3 = new Student();
        student3.setId(3365);
        student3.setStudentName("Robinson Otis");
        student3.setAddress("Los Angeles, California, USA");

        Student student4 = new Student();
        student4.setId(8547);
        student4.setStudentName("Allen paul");
        student4.setAddress("Los Angeles, California, USA");

        // [Persistent State]
        // Obj is associate with session as well as db also
        // In this state changes will also be reflected in db on updation
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
        session.persist(student4);
        saveStudents(session);

        // same obj value is updated here
        // student.setStudentName("Kelly bottom");

        // [Removed State]
        // value will be removed from db, but still associated with session
        // first get() the vale from db and then call delete() or remove()
        // session.remove();

        // commit values to make changes in db
        transaction.commit();

        // [Detached State]
        // obj is not associated with session anymore
        session.close();        // session.clear();
        // obj value will not be updated as session is closed
        //student.setStudentName("Amy Santiago");

        sessionFactory.close();
    }

    // crete dummy student list
    private static void saveStudents(Session session) {
        for (int i = 1; i <= 50; i++) {
            Student student = new Student();
            student.setId(i);
            student.setStudentName("Student 1"+ i);
            student.setAddress("City 1"+i);
            session.persist(student);
        }
    }
}