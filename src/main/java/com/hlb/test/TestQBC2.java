package com.hlb.test;

import com.hlb.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import javax.persistence.criteria.*;
import java.util.List;

public class TestQBC2{
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
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        //设定查询条件 from User
        Root<User> from = query.from(User.class);

        //设定其他条件
        query.where(criteriaBuilder.equal(from.get("id"),10)); //where id = 10

        //执行查询
        User user = session.createQuery(query).uniqueResult();
        System.out.println(user);

    }

    @Test
    public void m1(){
        //创建一个User的查询接口
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        //设定查询条件
        Root<User> from = query.from(User.class);

        //设定其他条件
        query.where(criteriaBuilder.between(from.<Comparable>get("id"),10,2000));

        //执行查询
        List<User> list = session.createQuery(query).list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void m2(){
        //创建一个User的接口
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        //设定查询条件
        Root<User> from = query.from(User.class);

        //设定其他条件
        Predicate id = criteriaBuilder.equal(from.get("id"), 10);
        Predicate equal = criteriaBuilder.equal(from.get("username"), "张无忌");

        query.where(criteriaBuilder.or(id, equal));

        //执行查询
        List<User> list = session.createQuery(query).list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void m3(){
        //创建一个User的查询接口
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        //设定查询条件
        Root<User> from = query.from(User.class);

        //设定其他条件
        Predicate id = criteriaBuilder.equal(from.get("id"), 10);
        query.where(criteriaBuilder.in(id));

        //执行查询
        List<User> list = session.createQuery(query).list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void m4()throws Exception{
        //获取所有
        //创建了一个User的查询接口
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);

        //设定查询条件  from User
        Root<User> user = query.from(User.class);

        //设定其他条件
        Predicate id = builder.equal(user.get("id"), 10);
        query.where(builder.in(id));  //  where id=10

        //执行查询
        List<User> user1 = session.createQuery(query).list();
        System.out.println(user1);
    }

    @Test
    public void mv(){
        //获取所有
        //创建了一个User的查询接口
        Object result = session.createCriteria(User.class)
                .add(Restrictions.eq("id", 1001))
                .uniqueResult();
        System.out.println(result);
    }

    @Test
    public void m5(){
        //测试删除
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<User> cd = criteriaBuilder.createCriteriaDelete(User.class);
        Root<User> from = cd.from(User.class);
        cd.where(criteriaBuilder.equal(from.get("id"), 1003));
        session.createQuery(cd);
        tran.commit();
    }

}