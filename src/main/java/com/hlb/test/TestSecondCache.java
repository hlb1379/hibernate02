package com.hlb.test;

import com.hlb.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by Fly on 2019/3/14.
 */
public class TestSecondCache {
    private static SessionFactory factory = null;
    private static Transaction transaction = null;

    static {
        Configuration configure = new Configuration().configure();
        factory = configure.buildSessionFactory();
    }

    @Test
    public void mm(){
        Session session = factory.openSession();
        User user = session.get(User.class, 3);
        User user1 = session.get(User.class, 9);
        System.out.println(user);
        session.close();

        session = factory.openSession();
        user = session.get(User.class, 3);
        System.out.println(user);
        session.close();
    }

}