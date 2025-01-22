package com.king.logistics.domain.oms;

import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.oms.Order;
import com.king.logistics.domain.oms.enums.ReturnStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "returns")
@AttributeOverride(name = "id", column = @Column(name="return_id"))
public class Return extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime returnDate;

    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReturnStatus returnStatus;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
