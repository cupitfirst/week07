package com.bh1ofp.week07.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "supplier")
@Entity
@Data
public class Supplier {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "contact")
    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}