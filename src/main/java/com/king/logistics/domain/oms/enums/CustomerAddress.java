package com.king.logistics.domain.oms.enums;

import com.king.logistics.domain.com.BaseEntity;
import com.king.logistics.domain.oms.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
public class CustomerAddress extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cutomer_id",nullable = false)
    private Customer customer;
    private AddressType address_type;
    private String address;
    private String city;
    private String state;
    private String postal_code;
    private String country;
}
