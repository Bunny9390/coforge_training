package com.company.supplierservice.service;

import com.company.supplierservice.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {

    SupplierDTO addSupplier(SupplierDTO supplierDTO);

    SupplierDTO updateSupplier(Long supplierId, SupplierDTO supplierDTO);

    void deleteSupplier(Long supplierId);

    SupplierDTO getSupplierById(Long supplierId);

    List<SupplierDTO> getAllSuppliers();
}
