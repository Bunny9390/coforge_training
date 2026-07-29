package com.company.supplierservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierId")
    private Long supplierId;

    @NotBlank(message = "Supplier name must not be blank")
    @Size(min = 2, max = 100, message = "Supplier name must be between 2 and 100 characters")
    @Column(name = "supplierName", nullable = false)
    private String supplierName;

    @NotBlank(message = "City must not be blank")
    @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
    @Column(name = "city", nullable = false)
    private String city;
}
