package com.king.logistics.controller.form;

import com.king.logistics.domain.wms.Supplier;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierCreateForm {
    private String name;
    private String contactInfo;

    public Supplier toEntity() {
        return new Supplier(null, name, contactInfo);
    }
}
