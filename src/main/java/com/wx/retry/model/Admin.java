package com.wx.retry.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description  :管理员表
 */
@Entity
@Table(name = "admin")
@Data
public class Admin implements Serializable{

    private static final long serialVersionUID = 1L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //编号，使用此信息登录
    @Column(name = "num")
    private Long num;
    //名字
    @Column(name = "name")
    private String name;
    //密码
    @Column(name = "password")
    private String password;
    //电话
    @Column(name = "phone")
    private String phone;
    //性别
    @Column(name = "sex")
    private String sex;

}
