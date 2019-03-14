package com.hlb.test;

import com.hlb.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import java.util.List;

public class TestSQL {
    private static Session session = null;
    private static Transaction tran = null;

    static {
        Configuration configure = new Configuration().configure();
        SessionFactory factory = configure.buildSessionFactory();
        session = factory.openSession();
        tran = session.beginTransaction();
    }

   @Test
    public void mm(){
       NativeQuery sqlQuery = session.createSQLQuery("select * from tb_user");
       sqlQuery.addEntity(User.class);
       List list = sqlQuery.list();
       for (Object o : list) {
           System.out.println(o);
       }
   }

   @Test
    public void m2(){
       Object result = session.createNamedQuery("com.hlb.pojo.User.getUserById")
               .setParameter(0, 3)
               .uniqueResult();
       System.out.println(result);
   }






}