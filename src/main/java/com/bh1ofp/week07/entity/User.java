package com.bh1ofp.week07.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Entity
@Data
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password")
    private String password;


}