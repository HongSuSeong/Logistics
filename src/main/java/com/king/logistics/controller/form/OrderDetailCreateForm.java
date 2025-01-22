package com.king.logistics.controller.form;

import com.king.logistics.domain.wms.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailCreateForm {
    private Long productId;
    private int quantity;
}
