package com.king.logistics.domain.wms;

import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.oms.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name="picking_id"))
public class Picking extends BaseEntity {

    private LocalDateTime pickingDate;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;
}
