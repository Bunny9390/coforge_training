package com.company.productservice.client;

import com.company.productservice.dto.SupplierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "supplier-service", path = "/api/suppliers")
public interface SupplierClient {

    /**
     * GET /api/suppliers/{supplierId}
     * Fetches supplier details from supplier-service via Eureka service discovery.
     *
     * @param supplierId the ID of the supplier
     * @return SupplierDTO containing supplier information
     */
    @GetMapping("/{supplierId}")
    SupplierDTO getSupplierById(@PathVariable("supplierId") Long supplierId);
}
