package com.hlb.test;

import com.hlb.pojo.Order;
import com.hlb.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by Fly on 2019/3/14.
 */
public class TestCl {

    private static Session session = null;
    private static Transaction transaction = null;

    static {
        Configuration configure = new Configuration().configure();
        SessionFactory factory = configure.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

    }

    @Test
    public void mm(){
        User user = session.get(User.class, 3);
        System.out.println(user.getOrders());
    }


    @Test
    public void m1(){
        Order user = session.get(Order.class, 3);
        System.out.println(user.getUser());
    }

}