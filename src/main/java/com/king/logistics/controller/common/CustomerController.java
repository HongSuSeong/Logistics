package com.king.logistics.controller.common;


import com.king.logistics.domain.oms.Customer;
import com.king.logistics.service.common.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/register")
    public String register(Model model, Customer customer) {
        model.addAttribute("customer",customer);
        return "common/register";
    }

    @PostMapping("/register")
    public String registerSave(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "index";
    }
}
