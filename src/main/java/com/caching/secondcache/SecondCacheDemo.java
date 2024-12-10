package com.caching.secondcache;

import com.states.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondCacheDemo {

    public static void main(String[] args) {

        // NOTE : For this to run weh have to use the same hibernate-ehcache & same hibernate-core version
        // and when we update or downgrade the maven dependency we just have to reimport all classes of jakarta.persistence.*
        // To enable second level cache we have to add annotation in the related class
        // @Cacheable
        // @Cache(usage = CacheConcurrencyStrategy.READ_ONLY) :
        // CacheConcurrencyStrategy.NONE, CacheConcurrencyStrategy.READ_WRITE, CacheConcurrencyStrategy.TRANSACTIONAL

        // Second level cache scope start here
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Second level cache scope start here
        // first session after clearing it
        Session session = sessionFactory.openSession();

        // getting object
        Student student = session.getReference(Student.class, 1122);
        System.out.println(student);

        // first session closes
        session.close();

        Session sessionSecond = sessionFactory.openSession();
        // second session after clearing it
        Student student1 = sessionSecond.getReference(Student.class, 1122);
        System.out.println(student1);
        // Even if the first session is closed & new second session is created
        // hb will fire only 1 query.

        // first level cache scope ends here
        sessionSecond.close();
        // Second level cache scope ends here
        sessionFactory.close();
    }
}
