package com.king.logistics.controller.oms;

import com.king.logistics.controller.form.OrderCreateForm;
import com.king.logistics.service.oms.OrderService;
import com.king.logistics.service.wms.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping("/list")
    public String orderList(Model model) {
        model.addAttribute("orders", orderService.OrderList());
        return "/oms/order/list";
    }

    @GetMapping("/create")
    public String SaveForm(Model model) {
        model.addAttribute("order", new OrderCreateForm());
        model.addAttribute("products", productService.list());
        return "/oms/order/create";
    }

    @PostMapping("/create")
    public String Save(@ModelAttribute("order") OrderCreateForm form) {
        return "/index";
    }
}
