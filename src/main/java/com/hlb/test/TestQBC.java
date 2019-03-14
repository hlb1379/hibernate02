package com.hlb.test;

import com.hlb.pojo.Order;
import com.hlb.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TestQBC{
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
        //查询所有
        //获取一个构造器
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        //构建查询
        CriteriaQuery<Order> query = criteriaBuilder.createQuery(Order.class);
        //设定条件为查询
        query.from(Order.class);
        //执行查询
        List<Order> resultList = session.createQuery(query).getResultList();
        for (Order order : resultList) {
            System.out.println(order);
        }
    }

    @Test
    public void m2(){
        //查询所有
        //获取一个构造器
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        //构建查询
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        //获取对象
        Root<User> userRoot = query.from(User.class);
        //设置条件
        //select * from user where username like '%无%'
        query.where(criteriaBuilder.like(userRoot.<String>get("username"), "%无%"));
        //执行查询
        List<User> resultList = session.createQuery(query).getResultList();
        for (User user : resultList) {
            System.out.println(user);
        }
    }

    @Test
    public void m3(){
        //查询所有
        //获取一个构造器
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        //构建查询
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        //获取根对象
        Root<User> userRoot = query.from(User.class);
        //设置条件
        CriteriaQuery<User> id = query.where(criteriaBuilder.between(userRoot.<Comparable>get("id"), 100, 2000));
        //执行查询
        List<User> resultList = session.createQuery(query).getResultList();
        System.out.println(id);
        for (User user : resultList) {
            System.out.println(user);
        }
    }

    @Test
    public void m4(){
        //查询所有
        //获取一个构造器
        Criteria criteria = session.createCriteria(User.class);
        List list = criteria.list();
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void m5(){
        //查询所有
        //获取一个构造器
        List id = session.createCriteria(User.class)
                .add(Restrictions.between("id", 100, 2000))
                .list();
        for (Object o : id) {
            System.out.println(o);
        }
    }

    @Test
    public void m6(){
        //查询所有
        //获取一个构造器
        List username = session.createCriteria(User.class)
                .add(Restrictions.like("username", "%大%"))
                .list();
        for (Object o : username) {
            System.out.println(o);
        }
    }

    @Test
    public void m7(){
        //分页查询
        //获取一个构造器
        List list = null;
        int a = 3;
        int b = 2;
        for (int i = 0;i<a;i+=b){
                list = session.createCriteria(User.class)
                .setFirstResult(i)
                .setMaxResults(b)
                .list();
            for (Object o : list) {
                System.out.println("第"+(i+1)+"页=====================");
                System.out.println(o);
            }
        }
    }

    @Test
    public void m8(){
        //获取一个构造器
        List list = session.createCriteria(User.class)
                .add(Restrictions.or(
                        Restrictions.like("username", "%大%"),
                        Restrictions.eq("id", 3)
                ))
                .list();
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void m9(){
        //获取一个构造器
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.where(criteriaBuilder.equal(from.<String>get("id"), 3));
        List<User> list = session.createQuery(query).list();
        for (User user : list) {
            System.out.println(list);
        }
    }

}