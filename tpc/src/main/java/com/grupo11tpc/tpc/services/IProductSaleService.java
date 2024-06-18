package com.grupo11tpc.tpc.services;

import java.util.List;

import com.grupo11tpc.tpc.dtos.ProductSaleDTO;
import com.grupo11tpc.tpc.entities.ProductSale;

public interface IProductSaleService {
	//Generar una nueva compra de productos
	public void sale(ProductSaleDTO productSaleDto) throws Exception;
	public List<ProductSale> getAll();
}
