package com.king.logistics.service.wms;

import com.king.logistics.domain.wms.Supplier;
import com.king.logistics.repository.wms.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public List<Supplier> list() {
        return supplierRepository.findAll();
    }

    public void create(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}
