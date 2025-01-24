package com.king.logistics.controller.form;

import com.king.logistics.domain.oms.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCrateForm {

    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer toEntity() {
        return new Customer(name,email,phone,address);
    }
}
