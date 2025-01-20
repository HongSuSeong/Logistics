package com.king.logistics.domain.wms;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Getter
@Setter
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplier_id")
    private Long id;

    private String name;

    private String contactInfo;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
}
