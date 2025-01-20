package com.king.logistics.domain.wms;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_id")
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
