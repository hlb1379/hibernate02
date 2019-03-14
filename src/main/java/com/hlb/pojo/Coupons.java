package com.hlb.pojo;

import java.io.Serializable;

/**
 * Created by Fly on 2019/3/13.
 */
public class Coupons implements Serializable{
    private Integer id;
    private Double money;
    private Double howmuch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getHowmuch() {
        return howmuch;
    }

    public void setHowmuch(Double howmuch) {
        this.howmuch = howmuch;
    }

    @Override
    public String toString() {
        return "Coupons{" +
                "id=" + id +
                ", money=" + money +
                ", howmuch=" + howmuch +
                '}';
    }
}