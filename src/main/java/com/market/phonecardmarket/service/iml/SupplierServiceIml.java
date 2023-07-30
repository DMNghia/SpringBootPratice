package com.market.phonecardmarket.service.iml;

import com.market.phonecardmarket.dto.SupplierDTO;
import com.market.phonecardmarket.entity.Supplier;
import com.market.phonecardmarket.mapper.SupplierMapper;
import com.market.phonecardmarket.repository.ISupplierRepository;
import com.market.phonecardmarket.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class SupplierServiceIml implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    private SupplierMapper supplierMapper = new SupplierMapper();

    @Override
    public List<SupplierDTO> getAllSupplier() {
        List<SupplierDTO> supplierDTOList = new ArrayList<>();
        List<Supplier> suppliers = supplierRepository.findAllByIsDeleteFalse();
        for (Supplier s : suppliers) {
            supplierDTOList.add(supplierMapper.entityToDTO(s));
        }
        return supplierDTOList;
    }

    @Override
    public Optional<SupplierDTO> findSupplierById(int id) {
        Optional<Supplier> supplier = Optional.ofNullable(supplierRepository.findByIdAndIsDeleteFalse(id));
        Optional<SupplierDTO> supplierDTO = Optional.of(new SupplierDTO());
        if (supplier.isPresent()) {
            supplierDTO = supplier.map(new Function<Supplier, SupplierDTO>() {
                @Override
                public SupplierDTO apply(Supplier supplier) {
                    return supplierMapper.entityToDTO(supplier);
                }
            });
        }
        return supplierDTO;
    }
}
