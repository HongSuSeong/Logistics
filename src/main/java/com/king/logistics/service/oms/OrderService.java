package com.king.logistics.service.oms;

import com.king.logistics.controller.form.OrderCreateForm;
import com.king.logistics.domain.oms.Order;
import com.king.logistics.domain.oms.OrderDetail;
import com.king.logistics.repository.oms.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> list() {
        return orderRepository.findAll();
    }

    public Order createOrder(OrderCreateForm form) {
        Order order = new Order();
        order.setOrderDate(form.getOrderDate());
        order.setOrderStatus(form.getOrderStatus());
        order.setCustomer(form.getCustomer());

        // OrderDetail 생성
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(form.getQuantity());
        orderDetail.setPrice(form.getPrice());
        orderDetail.setOrder(order);

        // OrderDetail을 Order에 추가
        order.setOrderDetails(List.of(orderDetail));

        // 주문 저장 (JPA Repository 사용)
        return orderRepository.save(order);
    }
}
