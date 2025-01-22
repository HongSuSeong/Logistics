package com.king.logistics.domain.wms;

import com.king.logistics.domain.com.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name="inventory_id"))
public class Inventory extends BaseEntity {

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
