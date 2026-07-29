package com.company.supplierservice.controller;

import com.company.supplierservice.dto.SupplierDTO;
import com.company.supplierservice.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
@Slf4j
public class SupplierController {

    private final SupplierService supplierService;

    /**
     * POST /api/suppliers
     * Add a new supplier
     */
    @PostMapping
    public ResponseEntity<SupplierDTO> addSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
        log.info("REST request to add supplier: {}", supplierDTO.getSupplierName());
        SupplierDTO savedSupplier = supplierService.addSupplier(supplierDTO);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    /**
     * GET /api/suppliers/{supplierId}
     * Get supplier by ID
     */
    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long supplierId) {
        log.info("REST request to get supplier by ID: {}", supplierId);
        SupplierDTO supplier = supplierService.getSupplierById(supplierId);
        return ResponseEntity.ok(supplier);
    }

    /**
     * GET /api/suppliers
     * Get all suppliers
     */
    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        log.info("REST request to get all suppliers");
        List<SupplierDTO> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    /**
     * PUT /api/suppliers/{supplierId}
     * Update an existing supplier
     */
    @PutMapping("/{supplierId}")
    public ResponseEntity<SupplierDTO> updateSupplier(
            @PathVariable Long supplierId,
            @Valid @RequestBody SupplierDTO supplierDTO) {
        log.info("REST request to update supplier with ID: {}", supplierId);
        SupplierDTO updatedSupplier = supplierService.updateSupplier(supplierId, supplierDTO);
        return ResponseEntity.ok(updatedSupplier);
    }

    /**
     * DELETE /api/suppliers/{supplierId}
     * Delete a supplier
     */
    @DeleteMapping("/{supplierId}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long supplierId) {
        log.info("REST request to delete supplier with ID: {}", supplierId);
        supplierService.deleteSupplier(supplierId);
        return ResponseEntity.ok("Supplier with ID " + supplierId + " deleted successfully.");
    }
}
