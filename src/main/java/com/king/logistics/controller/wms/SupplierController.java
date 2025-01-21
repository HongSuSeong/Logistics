package com.king.logistics.controller.wms;

import com.king.logistics.controller.form.SupplierCreateForm;
import com.king.logistics.domain.wms.Supplier;
import com.king.logistics.service.wms.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("suppliers",supplierService.list());
        return "/wms/supplier/list";
    }

    @GetMapping("/create")
    public String createForm(Model model, SupplierCreateForm form) {
        model.addAttribute("supplier",form);
        return "/wms/supplier/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("supplier") SupplierCreateForm form) {
        Supplier supplier = form.toEntity();
        supplierService.create(supplier);
        return "/wms/supplier/list";
    }
}
