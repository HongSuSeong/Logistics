package com.king.logistics.domain.tms;

import com.king.logistics.domain.oms.Order;
import com.king.logistics.domain.tms.enums.ShipmentStatus;
import com.king.logistics.domain.wms.Warehouse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Shipment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shipment_id")
    private Long id;

    private LocalDateTime shipmentDate;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus shipmentStatus;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliverys;
}
