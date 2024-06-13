package com.grupo11tpc.tpc.services;

import java.util.List;
import java.util.Optional;

import com.grupo11tpc.tpc.entities.Product;

;

public interface IProductService {
	
	public List<Product> getAll();

	public Optional<Product> findById(long id);

	public List<Product> findByName(String name) throws Exception;

	public Product insertOrUpdate(Product person);

	public boolean remove(long id);
}
