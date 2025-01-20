package com.king.logistics.domain.oms;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderDetail_id")
    private Long id;

    private int quantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
