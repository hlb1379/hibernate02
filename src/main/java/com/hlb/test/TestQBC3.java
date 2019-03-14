package com.hlb.test;

import com.hlb.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class TestQBC3 {
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
        //获取所有
        //创建了一个User的查询接口
        List list = session.createCriteria(User.class)
                .list();
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    //带条件查
    public void m1(){
        //获取所有
        List list = session.createCriteria(User.class)
//                .add(Restrictions.eq("username", "张无忌"))
//                .add(Restrictions.lt("id",5))
//                .add(Restrictions.like("username","%封%"))
//                .add(Restrictions.between("id",10,2000))
                .add(Restrictions.in("id",3,5,1001,1002))
                .list();
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    //带条件查
    public void m3(){
        //组合条件
        List list = session.createCriteria(User.class)
                .add(Restrictions.or(
                        Restrictions.eq("username","张无忌"),
                        Restrictions.like("username","%封%"),
                        Restrictions.like("username","%大%")))
//                .add(Restrictions.eq("username", "张无忌"))
//                .add(Restrictions.lt("id",5))
//                .add(Restrictions.like("username","%封%"))
//                .add(Restrictions.between("id",10,2000))
//                .add(Restrictions.in("id",3,5,1001,1002))
                .list();
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    //带条件查排序
    public void m4(){
        //排序
        List id = session.createCriteria(User.class)
                .addOrder(Order.desc("id")) //按照id的倒序排列
                .list();
        for (Object o : id) {
            System.out.println(o);
        }
    }

    @Test
    //带条件查排序
    public void m5(){
        //排序
        List id = session.createCriteria(User.class)
                .setProjection(Projections.avg("id"))
                .list();
        for (Object o : id) {
            System.out.println(o);
        }
    }

    @Test
    //带条件查排序
    public void m6(){
        //排序
        List id = session.createCriteria(com.hlb.pojo.Order.class)
                .setProjection(Projections.projectionList().add(Projections.rowCount()).add(Projections.groupProperty("user")))
                .list();
        for (Object o : id) {
            Object[] o1 = (Object[]) o;
            for (Object o2 : o1) {
                System.out.println(o2);
            }
        }
    }

    @Test
    //带条件查排序
    public void m7(){
        //排序
        List id = session.createCriteria(com.hlb.pojo.Order.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .list();
        for (Object o : id) {
            System.out.println(o);
        }
    }







}