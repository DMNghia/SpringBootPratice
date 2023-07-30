package com.market.phonecardmarket.mapper;

import com.market.phonecardmarket.dto.SupplierDTO;
import com.market.phonecardmarket.dto.UserDTO;
import com.market.phonecardmarket.entity.Supplier;
import com.market.phonecardmarket.entity.User;

public class SupplierMapper {
    public SupplierDTO entityToDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO().builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .image(supplier.getImage())
                .isDelete(supplier.isDelete())
                .createdAt(supplier.getCreatedAt())
                .createdBy(supplier.getCreatedBy())
                .updatedAt(supplier.getUpdatedAt())
                .updatedBy(supplier.getUpdatedBy())
                .build();

        return supplierDTO;
    }

    //Convert User dto to User entity
    public Supplier dtoToEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier().builder()
                .id(supplierDTO.getId())
                .name(supplierDTO.getName())
                .image(supplierDTO.getImage())
                .isDelete(supplierDTO.isDelete())
                .createdAt(supplierDTO.getCreatedAt())
                .createdBy(supplierDTO.getCreatedBy())
                .updatedAt(supplierDTO.getUpdatedAt())
                .updatedBy(supplierDTO.getUpdatedBy())
                .build();

        return supplier;
    }
}
