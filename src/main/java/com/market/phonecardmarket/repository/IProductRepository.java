package com.market.phonecardmarket.repository;

import com.market.phonecardmarket.entity.Product;
import com.market.phonecardmarket.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByIsDeleteFalseAndSupplier(Supplier supplier);
}
