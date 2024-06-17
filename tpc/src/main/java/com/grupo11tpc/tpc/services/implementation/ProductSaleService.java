package com.grupo11tpc.tpc.services.implementation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.grupo11tpc.tpc.dtos.ProductSaleDTO;
import com.grupo11tpc.tpc.entities.Product;
import com.grupo11tpc.tpc.entities.ProductSale;
import com.grupo11tpc.tpc.repositories.IProductRepository;
import com.grupo11tpc.tpc.repositories.IProductSaleRepository;
import com.grupo11tpc.tpc.services.IProductSaleService;

@Service
public class ProductSaleService implements IProductSaleService{
	
	private IProductRepository productRepository;
	private IProductSaleRepository productSaleRepository;
	
	public ProductSaleService(IProductRepository productRepository, IProductSaleRepository productSaleRepository) {
		super();
		this.productRepository = productRepository;
		this.productSaleRepository = productSaleRepository;
	}

	//Generar una nueva compra de productos
	@Override
	public void sale(ProductSaleDTO productSaleDto) throws Exception {
		//Se verifica que exista el producto
		Product pr = productRepository.findById(productSaleDto.getProductId()).orElseThrow();
		//Se verifica que se pueda hacer la venta
		if(productSaleDto.getAmount() > pr.getAmount()) 
			throw new Exception("No hay cantidad disponible para la venta");
		
		ProductSale ps = new ProductSale();
		
		ps.setProduct(pr);
		ps.setAmount(productSaleDto.getAmount());
		ps.setSaleDate(LocalDate.now());
		
		pr.setAmount(pr.getAmount()-productSaleDto.getAmount());
		
		productRepository.save(pr);
		productSaleRepository.save(ps);
	}

}
