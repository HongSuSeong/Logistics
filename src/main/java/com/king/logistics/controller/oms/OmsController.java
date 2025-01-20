package com.king.logistics.controller.oms;

import com.king.logistics.service.oms.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class OmsController {

    private final OrderService orderService;

    @GetMapping("/order")
    public String searchOrder(Model model) {
        model.addAttribute("orders", orderService.searchOrder());
        return "oms/orderList";
    }
}
