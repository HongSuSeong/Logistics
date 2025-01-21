package com.king.logistics.service.wms;

import com.king.logistics.domain.wms.Product;
import com.king.logistics.repository.wms.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public List<Product> list() {
        return productRepository.findAll();
    }

    public void create(Product product) {
        productRepository.save(product);
    }
}
