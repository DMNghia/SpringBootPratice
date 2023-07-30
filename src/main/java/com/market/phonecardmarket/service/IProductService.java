package com.market.phonecardmarket.service;

import com.market.phonecardmarket.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProductBySupplier(int supplierId);
}
