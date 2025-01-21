package com.king.logistics.domain.oms;

import com.king.logistics.domain.oms.enums.OrderStatus;
import com.king.logistics.domain.tms.Shipment;
import com.king.logistics.domain.wms.Packaging;
import com.king.logistics.domain.wms.Picking;
import com.king.logistics.domain.wms.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Return> returns;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Picking> pickings;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Packaging> packagings;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Shipment> shipments;

    public Order(Long orderId, LocalDateTime orderDate, int quantity, OrderStatus orderStatus, Customer customer, BigDecimal price) {
        this.id = orderId;
        this.orderDate = orderDate;
        this.totalAmount = BigDecimal.valueOf(quantity);
        this.orderStatus = orderStatus;
        this.customer = customer;
    }
}
