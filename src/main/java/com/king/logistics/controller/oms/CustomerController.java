package com.king.logistics.controller.oms;

import com.king.logistics.domain.oms.Customer;
import com.king.logistics.dto.oms.CustomerRegisterDto;
import com.king.logistics.service.oms.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/create")
    public String register(Model model, @ModelAttribute("customer") CustomerRegisterDto customerRegisterDto) {
        model.addAttribute("customer",customerRegisterDto);
        return "/oms/customer/create";
    }

    @PostMapping("/create")
    public String registerSave(@ModelAttribute("customer") CustomerRegisterDto customerRegisterDto) {
        Customer customer = customerRegisterDto.toEntity();
        customerService.createCustomer(customer);
        return "index";
    }
}
