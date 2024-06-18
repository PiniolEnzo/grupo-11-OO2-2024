package com.grupo11tpc.tpc.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo11tpc.tpc.entities.Product;
import com.grupo11tpc.tpc.entities.ProductSale;

@Repository("productSaleRepository")
public interface IProductSaleRepository extends JpaRepository<ProductSale, Serializable> {
	ProductSale findByProduct(Product product);
}
