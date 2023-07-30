package com.market.phonecardmarket.service;

import com.market.phonecardmarket.dto.SupplierDTO;
import com.market.phonecardmarket.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface ISupplierService {
    List<SupplierDTO> getAllSupplier();

    Optional<SupplierDTO> findSupplierById(int id);
}
