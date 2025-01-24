package com.king.logistics.domain.wms;

import com.king.logistics.domain.com.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name="product_id"))
public class Product extends BaseEntity {

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventory> inventories;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Product product;

    public Product(String name, String description, BigDecimal price, Supplier supplier) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplier = supplier;
    }
}
