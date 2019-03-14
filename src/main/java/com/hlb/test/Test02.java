package com.hlb.test;

import com.hlb.pojo.Coupons;
import com.hlb.pojo.Idcar;
import com.hlb.pojo.Order;
import com.hlb.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by Fly on 2019/3/13.
 */
public class Test02 {
    private Session session = null;
    private Transaction transaction =null;
    {
        Configuration configure = new Configuration().configure();
        SessionFactory factory = configure.buildSessionFactory();
        session = factory.openSession();
    }

    //测试优惠券有没有配置好
    @Test
    public void mm(){
        Coupons coupons = session.get(Coupons.class, 1);
        System.out.println(coupons);
    }

    //通过用户获取到用户的优惠券集合
    @Test
    public void m1(){
        User user = session.get(User.class, 3);
        System.out.println(user);
        List<Coupons> couponsList = user.getCouponsList();
        System.out.println(couponsList);

        /*//想要获取id为3的用户信息
        User user1 = session.get(User.class, 3);
        System.out.println(user1);*/

        //我要获取id为3的用户的身份证信息
        Idcar idcar = user.getIdcar();
        System.out.println(idcar);

        //我要获取id为3的用户的订单信息
        List<Order> orders = user.getOrders();
        System.out.println(orders);

        //我要获取id为3的用户的优惠券信息
        List<Coupons> couponsList1 = user.getCouponsList();
        System.out.println(couponsList1);
    }
}