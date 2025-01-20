package com.king.logistics.service.common;

import com.king.logistics.domain.oms.Customer;
import com.king.logistics.repository.common.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
