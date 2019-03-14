package com.hlb.test;

import com.hlb.pojo.Idcar;
import com.hlb.pojo.Order;
import com.hlb.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Fly on 2019/3/12.
 */
public class Test01 {
    private static Session session = null;
    private static Transaction transaction = null;


    static {
        Configuration configuration = new Configuration().configure();

        SessionFactory factory = configuration.buildSessionFactory();

        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();

        /*User user = session.get(User.class, 1);
        System.out.println(user);*/

        Order order = session.get(Order.class, 3);

        System.out.println(order);

    }

    @Test
    public void oneToMany(){
        User user = session.get(User.class, 1001);
        System.out.println(user);
        /*
        List<Order> orders = user.getOrders();
        System.out.println(orders);*/

        /*Set<Order> orderSet = user.getOrderSet();
        System.out.println(orderSet);*/

        Map<Integer,Order> orderMap = user.getOrderMap();
        System.out.println(orderMap);
    }

    //一对多级联配置
    @Test
    public void cacheConfig(){

        User user = session.get(User.class, 1);
        session.delete(user);
        transaction.commit();
    }

    //查询订单的时候，攻取关联的用户信息，订单是多，用户是一，多对一
    @Test
    public void manyToOne(){
        Order order = session.get(Order.class, 4);
        System.out.println(order);

        User user = order.getUser();
        System.out.println(user);
    }

    //一对一关系中，肯定有一方是主键方，一方是外键方（带外键的表就是外键方），先配外键方
    @Test
    public void oneToOne(){
        Idcar idcar = session.get(Idcar.class, 1);
        System.out.println(idcar);
        User user = idcar.getUser();
        System.out.println(user);
    }
    //一对一关系中，肯定有一方是主键方，一方是外键方（带外键的表就是外键方），先配外键方
    @Test
    public void oneToOne_(){
        User user = session.get(User.class, 3);
        System.out.println(user);
        Idcar idcar= user.getIdcar();
        System.out.println(idcar);
    }
}