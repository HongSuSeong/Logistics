package com.king.logistics.domain.oms;

import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.wms.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id" ,column = @Column(name="orderDetail_id"))
public class OrderDetail extends BaseEntity {

    @Min(value = 1, message = "수량은 1 이상이어야 합니다.")
    private int quantity;

    @PositiveOrZero(message = "가격은 0 이상이어야 합니다.")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
