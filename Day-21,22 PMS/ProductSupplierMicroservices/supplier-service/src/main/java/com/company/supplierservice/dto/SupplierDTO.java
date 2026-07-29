package com.company.supplierservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

    private Long supplierId;

    @NotBlank(message = "Supplier name must not be blank")
    @Size(min = 2, max = 100, message = "Supplier name must be between 2 and 100 characters")
    private String supplierName;

    @NotBlank(message = "City must not be blank")
    @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
    private String city;
}
