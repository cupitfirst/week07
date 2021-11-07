package com.bh1ofp.week07.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "order_detail")
@Entity
@Data
public class OrderDetail {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

//    @Column(name = "order_id")
//    private Integer orderId;

    @Column(name = "commodity_id")
    private Integer commodityId;

    @Column(name = "count")
    private Integer count;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "remark", length = 50)
    private String remark;

    @Column(name = "supplier_id")
    private Integer supplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;


}