package com.bh1ofp.week07.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "commodity")
@Entity
@Data
public class Commodity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "brand", length = 40)
    private String brand;

    @Column(name = "sku", length = 50)
    private String sku;


}