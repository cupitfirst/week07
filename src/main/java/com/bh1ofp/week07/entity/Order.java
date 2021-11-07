package com.bh1ofp.week07.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "orders")
@Entity
@Data
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    @Column(name = "order_no", length = 40)
    private String orderNo;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<OrderDetail> orderDetails;


}