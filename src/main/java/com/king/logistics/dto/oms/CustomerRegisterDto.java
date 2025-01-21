package com.king.logistics.dto.oms;

import com.king.logistics.domain.oms.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegisterDto {

    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer toEntity() {
        return new Customer(null,name,email,phone,address);
    }
}
