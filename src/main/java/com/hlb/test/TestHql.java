package com.hlb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Fly on 2019/3/13.
 */
public class TestHql {
    private Session session = null;
    private Transaction transaction =null;
    {
        Configuration configure = new Configuration().configure();
        SessionFactory factory = configure.buildSessionFactory();
        session = factory.openSession();
    }

    @Test
    public void mm(){
        //查询所有
        String hql = "from com.hlb.pojo.User";
        //创建查询接口
        Query query = session.createQuery(hql);
        List list = query.list(); //查询所有
        System.out.println(list);
    }

    @Test
    public void ml(){
        //返回单个对象
        String hql = "from com.hlb.pojo.User where id = ?1";

        //创建查询接口
        Query query = session.createQuery(hql);
        //设置参数
        query.setParameter(1, 4);
        //List list = query.list(); //查询单个对象

        Object result = query.uniqueResult();//查询单个对象

        System.out.println(result);
    }

    @Test
    public void m2(){
        //返回单个对象
        String hql = "select id,username,password from com.hlb.pojo.User where id = ?1";

        //创建查询接口
        Query query = session.createQuery(hql);
        //设置参数
        query.setParameter(1, 4);
        //List list = query.list(); //查询单个对象

        Object result = query.uniqueResult();//查询单个对象

        Object[] objects = (Object[])result;

        System.out.println(Arrays.toString(objects));
    }

    @Test
    public void m3(){
        //返回单个对象
        String hql = "select new User(id,username,password) from com.hlb.pojo.User where id = ?1";

        //创建查询接口
        Query query = session.createQuery(hql);
        //设置参数
        query.setParameter(1, 4);
        Object list = query.uniqueResult(); //查询单个对象


        System.out.println(list);
    }

    @Test
    public void m4(){
        //返回单个对象
        String hql = "select count(id) from com.hlb.pojo.User";

        //创建查询接口
        Query query = session.createQuery(hql);
        //设置参数
        //query.setParameter(1, 4);
        Object list = query.uniqueResult(); //查询单个对象


        System.out.println(list);
    }

    @Test
    //hibernate的链式编程
    public void m5(){
        String hql = "from User where id < ?0";
        Query query = session.createQuery(hql);
        query.setParameter(0,4);
        List list = query.list();
        System.out.println(list);

        List list1 = session.createQuery(hql).setParameter(0, 4).list();
        System.out.println(list1);
    }

    @Test
    //hql设置条件
    public void m6(){
        String hql = "from User where id between ?0 and ?1";
        List list = session.createQuery(hql)
                .setParameter(0, 10)
                .setParameter(1, 1003)
                .list();
        System.out.println(list);
    }

    @Test
    //hql设置条件二
    public void m7(){
        String hql = "from User where id in (:ids)";
        List list = session.createQuery(hql)
                .setParameterList("ids",new Object[]{3,1003})
                .list();
        System.out.println(list);
    }

    @Test
    //hql设置条件二
    public void m8(){
        String hql = "from User where id in (?0)";
        List list = session.createQuery(hql)
                .setParameterList(0,new Object[]{3,1003})
                .list();
        System.out.println(list);
    }

    @Test
    //hql设置条件二
    public void m9(){
        String hql = "from User where username like ?0";
        List list = session.createQuery(hql)
                .setParameter(0,"%无%")
                .list();
        System.out.println(list);
    }

    @Test
    //hql设置条件二
    public void m10(){
        String hql = "select max(id) from User";
        Object list = session.createQuery(hql)
                .uniqueResult();
        System.out.println(list);
    }
    @Test
    //hql设置条件二
    public void m11(){
        String hql = "select count(*) from Order o group by userid";
        Object list = session.createQuery(hql)
                .list();
        System.out.println(list);
    }
    @Test
    //hql设置条件二
    public void m12(){
        String hql = "select u from User u";
        Object list = session.createQuery(hql)
                .list();
        System.out.println(list);
    }
    @Test
    //hql设置条件二
    public void m13(){
        String hql = "from User order by id desc";
        Object list = session.createQuery(hql)
                .list();
        System.out.println(list);
    }
    @Test
    //hql设置条件二
    public void m14(){
        //select * from tab_user u inner join tab_order o on u.id=o.userid
        String hql = "select distinct(u) from User u inner join fetch u.orders where u.id=4";
        Object list = session.createQuery(hql)
                .list();
        System.out.println(list);
    }
    @Test
    //hql设置条件二
    public void m15(){
        //select * from tab_user u inner join tab_order o on u.id=o.userid
        //查询用户，希望获取到用户的优惠券信息
//        String hql = "select distinct(u) from User u inner join fetch u.orders where u.id=4";
        String hql = "select distinct(u) from User u inner join fetch u.couponsList where u.id = 4";
        Object list = session.createQuery(hql)
                .list();
        System.out.println(list);
    }

    @Test
    //分页
    public void mm16(){
        List list = session.createQuery("from User")
                .setFirstResult(0)
                .setMaxResults(3)
                .list();
        for (Object o : list) {
            System.out.println(o);
        }
    }
}