package com.grupo11tpc.tpc.services;

public interface IProductEntryService {
	//Alta de nuevo lote de stock de un producto de la organización.
	public void saveProductEntry(int receivedAmount, long purchasePrice);
}
