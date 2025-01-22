package com.king.logistics.domain.wms;

import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.tms.Shipment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name="warehouse_id"))
public class Warehouse extends BaseEntity {

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
