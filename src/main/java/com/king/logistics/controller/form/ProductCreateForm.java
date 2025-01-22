package com.king.logistics.controller.form;

import com.king.logistics.domain.wms.Product;
import com.king.logistics.domain.wms.Supplier;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreateForm {
    private String name;
    private String description;
    private BigDecimal price;
    private Supplier supplier;

    public Product toEntity() {
        return new Product(name,description,price,supplier);
    }
}
