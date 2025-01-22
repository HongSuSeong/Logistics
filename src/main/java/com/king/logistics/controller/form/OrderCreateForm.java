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
    private OrderStatus orderStatus;
    private Customer customer;
    private List<OrderDetailCreateForm> orderDetails;
}
