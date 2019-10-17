package com.netease.domain;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user") //table标签 指定数据库中对应的表名，id配置为主键，生成策略为: 主键由数据库自动生成（主要是自动增长型）
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //.AUTO:主键由程序控制。(例如由时间戳生成主键)
    private long id;
    private String name;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
