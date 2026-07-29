package com.company.productservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @NotBlank(message = "Product name must not be blank")
    @Size(min = 2, max = 200, message = "Product name must be between 2 and 200 characters")
    @Column(name = "productName", nullable = false)
    private String productName;

    @NotNull(message = "Price must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull(message = "Quantity must not be null")
    @Min(value = 0, message = "Quantity must be 0 or greater")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull(message = "Supplier ID must not be null")
    @Positive(message = "Supplier ID must be a positive number")
    @Column(name = "supplierId", nullable = false)
    private Long supplierId;
}
