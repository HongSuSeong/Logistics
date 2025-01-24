package com.king.logistics.controller.oms;

import com.king.logistics.domain.oms.Customer;
import com.king.logistics.controller.form.CustomerCrateForm;
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
    public String register(Model model, @ModelAttribute("customer") CustomerCrateForm customerCrateForm) {
        model.addAttribute("customer", customerCrateForm);
        return "/oms/customer/create";
    }

    @PostMapping("/create")
    public String registerSave(@ModelAttribute("customer") CustomerCrateForm customerCrateForm) {
        Customer customer = customerCrateForm.toEntity();
        customerService.createCustomer(customer);
        return "index";
    }
}
