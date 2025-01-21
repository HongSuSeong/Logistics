package com.king.logistics.controller.form;

import com.king.logistics.domain.oms.Customer;
import com.king.logistics.domain.oms.Order;
import com.king.logistics.domain.oms.OrderDetail;
import com.king.logistics.domain.oms.enums.OrderStatus;
import com.king.logistics.domain.wms.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderCreateForm {
    private LocalDateTime orderDate;
    private int quantity;
    private OrderStatus orderStatus;
    private Customer customer;
    private BigDecimal price;

    public Order toEntity() {
        return new Order(null, orderDate, quantity, orderStatus, customer, price);
    }
}
