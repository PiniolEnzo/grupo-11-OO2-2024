package com.grupo11tpc.tpc.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo11tpc.tpc.entities.Product;
import com.grupo11tpc.tpc.repositories.IProductRepository;
import com.grupo11tpc.tpc.services.IProductService;

@Service("productService")
public class ProductService implements IProductService {

	private IProductRepository productRepository;
	
	public ProductService(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(long id) {
		return this.productRepository.findById(id);
	}

	@Override
	public List<Product> findByName(String name) throws Exception {
		return productRepository.findByName(name).orElseThrow(() -> new Exception("ERROR no existe Producto con Nombre: " + name));
	}
	
	@Override
	public Product insertOrUpdate(Product product) {
		return productRepository.save(product);
	}

	@Override
	public boolean remove(long id) {
		try {
			this.productRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
