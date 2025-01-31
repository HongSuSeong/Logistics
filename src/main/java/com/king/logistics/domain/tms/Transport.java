package com.king.logistics.domain.tms;

import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.tms.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.swing.plaf.basic.BasicIconFactory;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name="transport_id"))
public class Transport extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String routeInfo;

    private String deliverName;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    private BigDecimal estimated_cost;

    private int estimated_time;

    private String priority;
}
