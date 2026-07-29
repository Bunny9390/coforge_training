package com.company.supplierservice.config;

import com.company.supplierservice.entity.Supplier;
import com.company.supplierservice.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final SupplierRepository supplierRepository;

    @Override
    public void run(String... args) throws Exception {
        if (supplierRepository.count() == 0) {
            log.info("Initializing sample supplier data...");

            supplierRepository.save(new Supplier(null, "ABC Technologies", "Chennai"));
            supplierRepository.save(new Supplier(null, "Global Traders", "Bangalore"));
            supplierRepository.save(new Supplier(null, "Tech World", "Hyderabad"));

            log.info("Sample supplier data initialized successfully. Total suppliers: {}", supplierRepository.count());
        } else {
            log.info("Supplier data already exists. Skipping initialization.");
        }
    }
}
