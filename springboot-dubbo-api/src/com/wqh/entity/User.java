package com.wqh.entity;


import java.io.Serializable;

/**
 * @ClassName User
 * @Author wqh
 * @Date 2021/1/5 9:54
 * @Description TODO
 * @Version 1.0
 */
public class User implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
