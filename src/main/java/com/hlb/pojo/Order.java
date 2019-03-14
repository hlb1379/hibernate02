package com.hlb.pojo;

import java.util.Date;

public class Order {
  private Integer id;
  private Integer num;
  private java.util.Date createtime;
  private Integer state;
  private Double totalprice;
  private Integer userid;
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public java.util.Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.util.Date createtime) {
    this.createtime = createtime;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Double getTotalprice() {
    return totalprice;
  }

  public void setTotalprice(Double totalprice) {
    this.totalprice = totalprice;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public Order() {
  }

  public Order(Integer id, Integer num, Date createtime, Integer state, Double totalprice, Integer userid) {
    this.id = id;
    this.num = num;
    this.createtime = createtime;
    this.state = state;
    this.totalprice = totalprice;
    this.userid = userid;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", num=" + num +
            ", createtime=" + createtime +
            ", state=" + state +
            ", totalprice=" + totalprice +
            ", userid=" + userid +
            '}';
  }

}
