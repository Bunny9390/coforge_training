package com.company.productservice.controller;

import com.company.productservice.dto.ProductDTO;
import com.company.productservice.dto.ProductResponseDTO;
import com.company.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    /**
     * POST /api/products
     * Add a new product
     */
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        log.info("REST request to add product: {}", productDTO.getProductName());
        ProductDTO savedProduct = productService.addProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    /**
     * GET /api/products/{productId}
     * Get product by ID
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long productId) {
        log.info("REST request to get product by ID: {}", productId);
        ProductDTO product = productService.getProduct(productId);
        return ResponseEntity.ok(product);
    }

    /**
     * GET /api/products
     * Get all products
     */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        log.info("REST request to get all products");
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * PUT /api/products/{productId}
     * Update an existing product
     */
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable Long productId,
            @Valid @RequestBody ProductDTO productDTO) {
        log.info("REST request to update product with ID: {}", productId);
        ProductDTO updatedProduct = productService.updateProduct(productId, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * DELETE /api/products/{productId}
     * Delete a product
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        log.info("REST request to delete product with ID: {}", productId);
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product with ID " + productId + " deleted successfully.");
    }

    /**
     * GET /api/products/supplier/{supplierId}
     * Get all products by supplier ID
     */
    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<ProductDTO>> getProductsBySupplier(@PathVariable Long supplierId) {
        log.info("REST request to get products by supplier ID: {}", supplierId);
        List<ProductDTO> products = productService.getProductsBySupplier(supplierId);
        return ResponseEntity.ok(products);
    }

    /**
     * GET /api/products/{productId}/supplier
     * Get product with full supplier details
     */
    @GetMapping("/{productId}/supplier")
    public ResponseEntity<ProductResponseDTO> getProductWithSupplier(@PathVariable Long productId) {
        log.info("REST request to get product with supplier details for ID: {}", productId);
        ProductResponseDTO response = productService.getProductWithSupplier(productId);
        return ResponseEntity.ok(response);
    }
}
