package com.king.logistics.domain.wms;

import com.king.logistics.domain.oms.Order;
import com.king.logistics.domain.wms.enums.PackagingType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Packaging {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="packaging_id")
    private Long id;

    private LocalDateTime packagingDate;

    @Enumerated(EnumType.STRING)
    private PackagingType packagingType;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
}
