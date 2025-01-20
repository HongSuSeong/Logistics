package com.king.logistics.domain.tms;

import com.king.logistics.domain.tms.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transport {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transport_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String routeInfo;

    private String deliverName;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;
}
