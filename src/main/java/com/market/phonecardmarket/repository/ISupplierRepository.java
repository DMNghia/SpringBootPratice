package com.market.phonecardmarket.repository;

import com.market.phonecardmarket.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
    List<Supplier> findAllByIsDeleteFalse();

    Supplier findByIdAndIsDeleteFalse(int id);
}
