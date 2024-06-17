package com.grupo11tpc.tpc.services;

import com.grupo11tpc.tpc.dtos.ProductSaleDTO;

public interface IProductSaleService {
	//Generar una nueva compra de productos
	public void sale(ProductSaleDTO productSaleDto) throws Exception;
}
