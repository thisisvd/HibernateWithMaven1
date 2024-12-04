package com.mapping.manyToMany;

import com.mapping.manyToMany.entity.Emp;
import com.mapping.manyToMany.entity.Project;
import com.mapping.oneToMany.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {

    public static void main(String[] args) throws Exception {

        // init and opening sessions
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // creating object
        Emp emp1 = new Emp();
        emp1.setEmpId(101);
        emp1.setEmpName("Phil Dunphy");

        Emp emp2 = new Emp();
        emp2.setEmpId(102);
        emp2.setEmpName("Gloria Prichet");

        Project p1 = new Project();
        Project p2 = new Project();

        p1.setProjectId(1111);
        p1.setProjectName("Automated Video Matrix");

        p2.setProjectId(2222);
        p2.setProjectName("Online Ludo Game");

        List<Emp> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        List<Project> projectList = new ArrayList<>();
        projectList.add(p1);
        projectList.add(p2);

        // assign 2 projects to employee1
        emp1.setProjects(projectList);
        // assign 2 employee to project2
        p2.setEmployees(empList);

        // getting current session
        Session session = sessionFactory.openSession();

        // starting transaction
        Transaction transaction = session.beginTransaction();

        // save object
        session.persist(emp1);
        session.persist(emp2);
        session.persist(p1);
        session.persist(p2);

        // commiting all in db
        transaction.commit();

        // closing session factory
        sessionFactory.close();
    }
}
