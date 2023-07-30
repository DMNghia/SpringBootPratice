package com.market.phonecardmarket.mapper;

import com.market.phonecardmarket.dto.ProductDTO;
import com.market.phonecardmarket.dto.SupplierDTO;
import com.market.phonecardmarket.entity.Product;
import com.market.phonecardmarket.entity.Supplier;

public class ProductMapper {
    public ProductDTO entityToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO().builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .supplier(product.getSupplier())
                .isDelete(product.isDelete())
                .createdAt(product.getCreatedAt())
                .createdBy(product.getCreatedBy())
                .updatedAt(product.getUpdatedAt())
                .updatedBy(product.getUpdatedBy())
                .build();

        return productDTO;
    }

    //Convert User dto to User entity
    public Product dtoToEntity(ProductDTO productDTO) {
        Product product = new Product().builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .supplier(productDTO.getSupplier())
                .isDelete(productDTO.isDelete())
                .createdAt(productDTO.getCreatedAt())
                .createdBy(productDTO.getCreatedBy())
                .updatedAt(productDTO.getUpdatedAt())
                .updatedBy(productDTO.getUpdatedBy())
                .build();

        return product;
    }
}
