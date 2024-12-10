package com.caching.firstcache;

import com.states.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstCacheDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // First level cache : It is enabled by default
        Student student = session.getReference(Student.class, 1122);
        System.out.println("1. " + student);
        System.out.println("Working something...");

        // check obj in session
        System.out.println(session.contains(student));

        // hibernate will check the id (PK) in the cache and if it will find the value
        // then it will not process another db query, and take the object from cache and will return it
        Student student2 = session.getReference(Student.class, 1122);
        System.out.println("2. " + student2);

        // this time a call to db will be done because hibernate will observe a new primary key
        Student student3 = session.getReference(Student.class, 2233);
        System.out.println("3. " + student3);

        System.out.println("1. PK : " + session.contains(student) + " : 2. PK : " + session.contains(student3));

        // refresh will remove the obj from cache & a new db call will be done next time
        session.refresh(student);

        Student student11 = session.getReference(Student.class, 1122);
        Student student33 = session.getReference(Student.class, 2233);
        System.out.println(student11.getStudentName() + " : " + student33.getStudentName());

        Student student111 = session.getReference(Student.class, 1122);
        System.out.println(student111.getStudentName() + " : " + student111.getAddress());

        // when we will clear or close the session all cache will be cleared
        session.close();
        sessionFactory.close();
    }
}
