package com.company.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private SupplierDTO supplier;
}
