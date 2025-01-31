package com.king.logistics.repository.wms;

import com.king.logistics.domain.wms.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SupplierRepositoryTest {

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    void 공급자_저장_테스트() {
        Supplier supplier = Supplier.builder()
                .name("abc Logistics")
                .contactInfo("contact@abclogistics.com")
                .build();

        Supplier savedSupplier = supplierRepository.save(supplier);

        long count = supplierRepository.count();

        assertThat(savedSupplier.getName()).isEqualTo("abc Logistics");
        assertThat(savedSupplier.getContactInfo()).isEqualTo("contact@abclogistics.com");

    }

}