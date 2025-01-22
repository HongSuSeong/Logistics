package com.king.logistics.service.oms;

import com.king.logistics.controller.form.OrderCreateForm;
import com.king.logistics.controller.form.OrderDetailCreateForm;
import com.king.logistics.domain.oms.Order;
import com.king.logistics.domain.oms.OrderDetail;
import com.king.logistics.domain.wms.Product;
import com.king.logistics.repository.oms.OrderRepository;
import com.king.logistics.repository.wms.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public List<Order> list() {
        return orderRepository.findAll();
    }

    public Order createOrder(OrderCreateForm form) {
        int totalAmount = 0;

        Order order = new Order();
        order.setOrderDate(form.getOrderDate());
        order.setOrderStatus(form.getOrderStatus());
        order.setCustomer(form.getCustomer());
        List<OrderDetail> orderDetails = form.getOrderDetails().stream().map(detailForm -> {
            Product product = productRepository.findById(detailForm.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(product);
            orderDetail.setQuantity(detailForm.getQuantity());
            orderDetail.setPrice(product.getPrice().multiply(BigDecimal.valueOf(detailForm.getQuantity())));
            orderDetail.setOrder(order);

            return orderDetail;
        }).collect(Collectors.toList());

        int quantity = 0;
        ListIterator<OrderDetail> orderDetailListIterator = orderDetails.listIterator();
        while (orderDetailListIterator.hasNext()) {
            quantity += orderDetailListIterator.next().getQuantity();
        }

        System.out.println("quantity = " + quantity);
        order.setTotalAmount(BigDecimal.valueOf(quantity));
        order.setOrderDetails(orderDetails);

        return orderRepository.save(order);
    }
}
