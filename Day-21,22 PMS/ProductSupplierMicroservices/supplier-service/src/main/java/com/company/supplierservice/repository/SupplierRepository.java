package com.company.supplierservice.repository;

import com.company.supplierservice.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    boolean existsBySupplierNameIgnoreCase(String supplierName);
}
