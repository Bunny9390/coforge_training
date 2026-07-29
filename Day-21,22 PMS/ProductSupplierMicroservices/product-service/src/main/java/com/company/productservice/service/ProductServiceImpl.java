package com.company.productservice.service;

import com.company.productservice.client.SupplierClient;
import com.company.productservice.dto.ProductDTO;
import com.company.productservice.dto.ProductResponseDTO;
import com.company.productservice.dto.SupplierDTO;
import com.company.productservice.entity.Product;
import com.company.productservice.exception.*;
import com.company.productservice.repository.ProductRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SupplierClient supplierClient;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        log.info("Adding new product: {}", productDTO.getProductName());

        if (productDTO.getSupplierId() == null || productDTO.getSupplierId() <= 0) {
            throw new InvalidSupplierIdException(productDTO.getSupplierId());
        }

        if (productRepository.existsByProductNameIgnoreCase(productDTO.getProductName())) {
            throw new DuplicateProductException(
                    "Product already exists with name: " + productDTO.getProductName());
        }

        // Validate supplier exists via Feign
        validateSupplierExists(productDTO.getSupplierId());

        Product product = mapToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        log.info("Product added successfully with ID: {}", savedProduct.getProductId());
        return mapToDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        log.info("Updating product with ID: {}", productId);

        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        if (productDTO.getSupplierId() == null || productDTO.getSupplierId() <= 0) {
            throw new InvalidSupplierIdException(productDTO.getSupplierId());
        }

        // Validate supplier exists via Feign
        validateSupplierExists(productDTO.getSupplierId());

        existingProduct.setProductName(productDTO.getProductName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());
        existingProduct.setSupplierId(productDTO.getSupplierId());

        Product updatedProduct = productRepository.save(existingProduct);
        log.info("Product updated successfully with ID: {}", updatedProduct.getProductId());
        return mapToDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        log.info("Deleting product with ID: {}", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        productRepository.delete(product);
        log.info("Product deleted successfully with ID: {}", productId);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProduct(Long productId) {
        log.info("Fetching product with ID: {}", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        return mapToDTO(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        log.info("Fetching all products");

        return productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsBySupplier(Long supplierId) {
        log.info("Fetching products for supplier ID: {}", supplierId);

        if (supplierId == null || supplierId <= 0) {
            throw new InvalidSupplierIdException(supplierId);
        }

        return productRepository.findBySupplierId(supplierId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDTO getProductWithSupplier(Long productId) {
        log.info("Fetching product with supplier details for product ID: {}", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        SupplierDTO supplierDTO = fetchSupplierDetails(product.getSupplierId());

        return new ProductResponseDTO(
                product.getProductId(),
                product.getProductName(),
                product.getPrice(),
                product.getQuantity(),
                supplierDTO
        );
    }

    // ─── Private Helper Methods ────────────────────────────────────────────────

    private void validateSupplierExists(Long supplierId) {
        try {
            supplierClient.getSupplierById(supplierId);
        } catch (FeignException.NotFound ex) {
            throw new SupplierNotFoundException(supplierId);
        } catch (FeignException ex) {
            throw new SupplierServiceDownException(
                    "Supplier service is currently unavailable. Cannot validate supplier ID: " + supplierId);
        }
    }

    private SupplierDTO fetchSupplierDetails(Long supplierId) {
        try {
            return supplierClient.getSupplierById(supplierId);
        } catch (FeignException.NotFound ex) {
            throw new SupplierNotFoundException(supplierId);
        } catch (FeignException ex) {
            throw new SupplierServiceDownException();
        }
    }

    // ─── Mapper Methods ────────────────────────────────────────────────────────

    private Product mapToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setSupplierId(dto.getSupplierId());
        return product;
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setSupplierId(product.getSupplierId());
        return dto;
    }
}
