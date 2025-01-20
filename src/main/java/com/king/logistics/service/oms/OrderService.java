package com.king.logistics.service.oms;

import com.king.logistics.domain.oms.Order;
import com.king.logistics.repository.oms.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> searchOrder() {
        return orderRepository.findAll();
    }
}
