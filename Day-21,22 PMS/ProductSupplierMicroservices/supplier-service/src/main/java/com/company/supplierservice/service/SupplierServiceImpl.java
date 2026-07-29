package com.company.supplierservice.service;

import com.company.supplierservice.dto.SupplierDTO;
import com.company.supplierservice.entity.Supplier;
import com.company.supplierservice.exception.DuplicateSupplierException;
import com.company.supplierservice.exception.SupplierNotFoundException;
import com.company.supplierservice.repository.SupplierRepository;
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
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public SupplierDTO addSupplier(SupplierDTO supplierDTO) {
        log.info("Adding new supplier: {}", supplierDTO.getSupplierName());

        if (supplierRepository.existsBySupplierNameIgnoreCase(supplierDTO.getSupplierName())) {
            throw new DuplicateSupplierException(
                    "Supplier already exists with name: " + supplierDTO.getSupplierName());
        }

        Supplier supplier = mapToEntity(supplierDTO);
        Supplier savedSupplier = supplierRepository.save(supplier);
        log.info("Supplier added successfully with ID: {}", savedSupplier.getSupplierId());
        return mapToDTO(savedSupplier);
    }

    @Override
    public SupplierDTO updateSupplier(Long supplierId, SupplierDTO supplierDTO) {
        log.info("Updating supplier with ID: {}", supplierId);

        Supplier existingSupplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException(supplierId));

        existingSupplier.setSupplierName(supplierDTO.getSupplierName());
        existingSupplier.setCity(supplierDTO.getCity());

        Supplier updatedSupplier = supplierRepository.save(existingSupplier);
        log.info("Supplier updated successfully with ID: {}", updatedSupplier.getSupplierId());
        return mapToDTO(updatedSupplier);
    }

    @Override
    public void deleteSupplier(Long supplierId) {
        log.info("Deleting supplier with ID: {}", supplierId);

        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException(supplierId));

        supplierRepository.delete(supplier);
        log.info("Supplier deleted successfully with ID: {}", supplierId);
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierDTO getSupplierById(Long supplierId) {
        log.info("Fetching supplier with ID: {}", supplierId);

        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException(supplierId));

        return mapToDTO(supplier);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplierDTO> getAllSuppliers() {
        log.info("Fetching all suppliers");

        return supplierRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ─── Mapper Methods ───────────────────────────────────────────────────────

    private Supplier mapToEntity(SupplierDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(dto.getSupplierName());
        supplier.setCity(dto.getCity());
        return supplier;
    }

    private SupplierDTO mapToDTO(Supplier supplier) {
        SupplierDTO dto = new SupplierDTO();
        dto.setSupplierId(supplier.getSupplierId());
        dto.setSupplierName(supplier.getSupplierName());
        dto.setCity(supplier.getCity());
        return dto;
    }
}
