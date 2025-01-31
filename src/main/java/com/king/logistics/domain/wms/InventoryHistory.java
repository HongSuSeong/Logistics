package com.king.logistics.domain.wms;

import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.wms.enums.ChangeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "history_id"))

public class InventoryHistory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    private LocalDateTime ChangeDate;

    @Enumerated(EnumType.STRING)
    private ChangeType changeType;

    private int quantity;

    private String notes;
}
