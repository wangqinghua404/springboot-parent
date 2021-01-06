package com.wqh.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName User
 * @Author wqh
 * @Date 2021/1/5 9:54
 * @Description TODO
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
