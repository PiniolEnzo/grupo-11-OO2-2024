package com.grupo11tpc.tpc.services;

public interface IProductSaleService {
	//Generar una nueva compra de productos
	public void sale(int amount, int productId) throws Exception;
}
