package com.company.supplierservice.exception;

public class SupplierNotFoundException extends RuntimeException {

    public SupplierNotFoundException(String message) {
        super(message);
    }

    public SupplierNotFoundException(Long supplierId) {
        super("Supplier not found with ID: " + supplierId);
    }
}
