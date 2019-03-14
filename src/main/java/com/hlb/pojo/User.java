package com.hlb.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User implements Serializable {
  private Integer id;
  private String username;
  private String password;
  private String addr;
  private String telephone;
  private List<Coupons> couponsList;

  private List<Order> orders;
  private Set<Order> orderSet;
  private Map<Integer,Order> orderMap;
  private Idcar idcar;

  public Idcar getIdcar() {
    return idcar;
  }

  public void setIdcar(Idcar idcar) {
    this.idcar = idcar;
  }

  public Map<Integer, Order> getOrderMap() {
    return orderMap;
  }

  public void setOrderMap(Map<Integer, Order> orderMap) {
    this.orderMap = orderMap;
  }

  public Set<Order> getOrderSet() {
    return orderSet;
  }

  public void setOrderSet(Set<Order> orderSet) {
    this.orderSet = orderSet;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public void setCouponsList(List<Coupons> couponsList) {
    this.couponsList = couponsList;
  }

  public List<Coupons> getCouponsList() {
    return couponsList;
  }
  public User() {
  }

  public User(Integer id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public User(Integer id, String username, String password, String addr, String telephone, List<Order> orders, Set<Order> orderSet) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.addr = addr;
    this.telephone = telephone;
    this.orders = orders;
    this.orderSet = orderSet;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", addr='" + addr + '\'' +
            ", telephone='" + telephone + '\'' +
            ", couponsList=" + couponsList +
            ", orders=" + orders +
            ", orderSet=" + orderSet +
            ", orderMap=" + orderMap +
            ", idcar=" + idcar +
            '}';
  }
}



