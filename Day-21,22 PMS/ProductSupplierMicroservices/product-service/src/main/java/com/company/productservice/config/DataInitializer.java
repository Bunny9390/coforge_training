package com.company.productservice.config;

import com.company.productservice.entity.Product;
import com.company.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            log.info("Initializing sample product data...");

            // Note: supplierId 1, 2, 3 correspond to "ABC Technologies", "Global Traders", "Tech World"
            // (auto-generated IDs from supplier-service)
            productRepository.save(new Product(null, "Laptop", 65000.0, 20, 1L));
            productRepository.save(new Product(null, "Mouse", 700.0, 100, 1L));
            productRepository.save(new Product(null, "Keyboard", 1200.0, 50, 2L));

            log.info("Sample product data initialized successfully. Total products: {}", productRepository.count());
        } else {
            log.info("Product data already exists. Skipping initialization.");
        }
    }
}
