package com.king.logistics.domain.oms;

import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.wms.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id" ,column = @Column(name="orderDetail_id"))
public class OrderDetail extends BaseEntity {

    private int quantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
