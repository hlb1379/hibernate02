package com.hlb.pojo;

import java.util.Date;

public class Idcar {
  private Integer id;
  private java.util.Date birthday;
  private String addr;
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

  public java.util.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.util.Date birthday) {
    this.birthday = birthday;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public Idcar() {
  }

  public Idcar(Integer id, Date birthday, String addr, Integer userid) {
    this.id = id;
    this.birthday = birthday;
    this.addr = addr;
    this.userid = userid;
  }

  @Override
  public String toString() {
    return "Idcar{" +
            "id=" + id +
            ", birthday=" + birthday +
            ", addr='" + addr + '\'' +
            ", userid=" + userid +
            '}';
  }
}
