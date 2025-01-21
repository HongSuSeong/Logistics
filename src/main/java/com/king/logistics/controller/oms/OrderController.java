package com.king.logistics.controller.oms;

import com.king.logistics.controller.form.OrderCreateForm;
import com.king.logistics.domain.oms.Order;
import com.king.logistics.domain.oms.OrderDetail;
import com.king.logistics.service.oms.CustomerService;
import com.king.logistics.service.oms.OrderService;
import com.king.logistics.service.wms.ProductService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final CustomerService customerService;

    @GetMapping("/list")
    public String orderList(Model model) {
        model.addAttribute("orders", orderService.list());
        return "/oms/order/list";
    }

    @GetMapping("/create")
    public String CreateForm(Model model) {
        model.addAttribute("order", new OrderCreateForm());
        model.addAttribute("products", productService.list());
        model.addAttribute("customers", customerService.list());
        return "/oms/order/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("order") OrderCreateForm form) {
        orderService.createOrder(form);
        return "/oms/order/list";
    }
}
