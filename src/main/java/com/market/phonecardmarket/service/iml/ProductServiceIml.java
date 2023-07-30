package com.market.phonecardmarket.service.iml;

import com.market.phonecardmarket.dto.ProductDTO;
import com.market.phonecardmarket.dto.SupplierDTO;
import com.market.phonecardmarket.entity.Product;
import com.market.phonecardmarket.entity.Supplier;
import com.market.phonecardmarket.mapper.ProductMapper;
import com.market.phonecardmarket.mapper.SupplierMapper;
import com.market.phonecardmarket.repository.IProductRepository;
import com.market.phonecardmarket.repository.ISupplierRepository;
import com.market.phonecardmarket.service.IProductService;
import com.market.phonecardmarket.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIml implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ISupplierService supplierService;

    private ProductMapper productMapper = new ProductMapper();

    private SupplierMapper supplierMapper = new SupplierMapper();
    @Override
    public List<ProductDTO> getAllProductBySupplier(int supplierId) {
        Optional<SupplierDTO> supplierDTO = supplierService.findSupplierById(supplierId);
        Supplier supplier = supplierMapper.dtoToEntity(supplierDTO.get());
        List<Product> productList = productRepository.findAllByIsDeleteFalseAndSupplier(supplier);
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product p : productList) {
            productDTOList.add(productMapper.entityToDTO(p));
        }

        return productDTOList;
    }
}
