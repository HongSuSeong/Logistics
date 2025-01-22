package com.king.logistics.service.oms;

import com.king.logistics.domain.oms.Customer;
import com.king.logistics.repository.oms.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public List<Customer> list() {
        return customerRepository.findAll();
    }
}
