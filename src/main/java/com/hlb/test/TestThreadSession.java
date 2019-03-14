package com.hlb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestThreadSession {
    private static Session session = null;
    private static Transaction tran = null;
    private static SessionFactory factory = null;

    static {
        Configuration configure = new Configuration().configure();
        factory= configure.buildSessionFactory();

       /* session = factory.getCurrentSession();
        tran = session.beginTransaction();*/
    }

    @Test
    public void mm(){
        Session s1 = factory.openSession();
        Session s2 = factory.openSession();
        System.out.println(s1==s2);
    }

    @Test
    public void m1(){
        Session s1 = factory.getCurrentSession();
        Session s2 = factory.getCurrentSession();
        System.out.println(s1==s2);
    }




}