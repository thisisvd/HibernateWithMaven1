package com.xml;

import com.xml.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlMappingDemo {

    public static void main(String[] args) throws Exception {

        // Mapping xml :
        // create a java pojo data class without any annotations
        // create a class_name.hbm.xml file in resources folder
        // add and match properties between xml & .java class
        // assign path of that resource folder in cfg.xml file
        // enjoy coding

        // init session factory and open sessions
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        // being a transaction
        Transaction transaction = session.beginTransaction();

        // creating object
        Person person = new Person(23, "Luke", "Arizona, USA", "123-456789");

        // save data
        session.merge(person);

        // commit changes
        transaction.commit();
        // closing sessions
        session.close();
        sessionFactory.close();
    }
}