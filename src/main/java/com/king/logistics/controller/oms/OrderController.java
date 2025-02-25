package com.king.logistics.controller.oms;

import com.king.logistics.controller.form.OrderCreateForm;
import com.king.logistics.controller.form.ProductListFrom;
import com.king.logistics.domain.oms.Order;
import com.king.logistics.service.oms.CustomerService;
import com.king.logistics.service.oms.OrderService;
import com.king.logistics.service.wms.ProductService;
import lombok.AllArgsConstructor;
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
        List<Order> orders = orderService.list();
        return "/oms/order/list";
    }

    @GetMapping("/create")
    public String CreateForm(Model model) {
        List<ProductListFrom> productListFroms = productService.list().stream()
                .map(product -> new ProductListFrom(product.getId(),product.getName()))
                .toList();
        model.addAttribute("order", new OrderCreateForm());
        model.addAttribute("products", productListFroms);
        model.addAttribute("customers", customerService.list());
        return "/oms/order/create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("order") OrderCreateForm form) {
        orderService.createOrder(form);
        model.addAttribute("orders",orderService.list());
        return "/oms/order/list";
    }
}
