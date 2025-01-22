package com.king.logistics.domain.wms;

import com.king.logistics.domain.com.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name="supplier_id"))
public class Supplier extends BaseEntity {

    private String name;

    private String contactInfo;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public Supplier(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }
}
