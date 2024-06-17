package com.grupo11tpc.tpc.services.implementation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

import com.grupo11tpc.tpc.entities.Product;
import com.grupo11tpc.tpc.entities.ProductSale;
import com.grupo11tpc.tpc.repositories.IProductRepository;
import com.grupo11tpc.tpc.repositories.IProductSaleRepository;
import com.grupo11tpc.tpc.services.IProductSaleService;

public class ProductSaleService implements IProductSaleService{
	
	private IProductRepository productRepository;
	private IProductSaleRepository productSaleRepository;
	
	public ProductSaleService(IProductRepository productRepository, IProductSaleRepository productSaleRepository) {
		super();
		this.productRepository = productRepository;
		this.productSaleRepository = productSaleRepository;
	}

	@Value("${product.minimal.amount}")
	private int minimalAmount;

	//Generar una nueva compra de productos
	@Override
	public void sale(int amount, int productId) throws Exception {
		//Se verifica que exista el producto
		Product pr = productRepository.findById(productId).orElseThrow();
		//Se verifica que se pueda hacer la venta
		if(amount > pr.getAmount()) 
			throw new Exception("No hay cantidad disponible para la venta");
		
		ProductSale ps = new ProductSale();
		
		ps.setProduct(pr);
		ps.setAmount(amount);
		ps.setSaleDate(LocalDate.now());
		
		pr.setAmount(pr.getAmount()-amount);
		
		if(pr.getAmount() < minimalAmount) {
			//Pedido de aprovisionamiento
		}
		
		productRepository.save(pr);
		productSaleRepository.save(ps);
	}

}
