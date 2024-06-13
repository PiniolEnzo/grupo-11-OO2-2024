package com.grupo11tpc.tpc.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo11tpc.tpc.entities.Product;

@Repository("productRepository")
public interface IProductRepository extends JpaRepository<Product, Serializable> {
	
	public abstract Optional<Product> findById(long id);
	
	public abstract Optional<List<Product>> findByName(String name);
}
