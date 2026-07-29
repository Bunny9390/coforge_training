package com.company.productservice.service;

import com.company.productservice.dto.ProductDTO;
import com.company.productservice.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long productId, ProductDTO productDTO);

    void deleteProduct(Long productId);

    ProductDTO getProduct(Long productId);

    List<ProductDTO> getAllProducts();

    List<ProductDTO> getProductsBySupplier(Long supplierId);

    ProductResponseDTO getProductWithSupplier(Long productId);
}
