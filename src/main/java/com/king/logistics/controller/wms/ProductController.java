package com.king.logistics.controller.wms;

import com.king.logistics.controller.form.ProductCreateForm;
import com.king.logistics.domain.wms.Product;
import com.king.logistics.service.oms.CustomerService;
import com.king.logistics.service.wms.ProductService;
import com.king.logistics.service.wms.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final SupplierService supplierService;
    private final CustomerService customerService;
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products",productService.list());
        return "/wms/product/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new ProductCreateForm());
        model.addAttribute("customers", customerService.list());
        model.addAttribute("suppliers", supplierService.list());
        return "/wms/product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") ProductCreateForm form) {
        Product product = form.toEntity();
        productService.create(product);
        return "/wms/product/list";
    }
}
