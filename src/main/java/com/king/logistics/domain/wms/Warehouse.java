package com.king.logistics.domain.wms;

import com.king.logistics.domain.tms.Shipment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Warehouse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="warehouse_id")
    private Long id;

    private String name;

    private String location;

    private int capacity;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventory> inventories;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Picking> pickings;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shipment> shipments;
}
