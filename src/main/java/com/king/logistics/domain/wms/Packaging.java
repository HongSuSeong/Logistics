package com.king.logistics.domain.wms;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.oms.Order;
import com.king.logistics.domain.wms.enums.PackagingType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name="packaging_id"))
public class Packaging extends BaseEntity {

    private LocalDateTime packagingDate;

    @Enumerated(EnumType.STRING)
    private PackagingType packagingType;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
}
