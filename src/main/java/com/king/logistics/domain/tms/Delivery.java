package com.king.logistics.domain.tms;

import com.king.logistics.domain.tms.enums.DeliveryStatus;
import com.king.logistics.domain.tms.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="delivery_id")
    private Long id;

    private LocalDateTime deliveryDate;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private String carrier;

    @ManyToOne
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transport> transports;
}
