package com.grupo11tpc.tpc.services;

import java.util.List;

import com.grupo11tpc.tpc.dtos.ProductEntryDTO;
import com.grupo11tpc.tpc.entities.ProductEntry;

public interface IProductEntryService {
	//Alta de nuevo lote de stock de un producto de la organización.
	public void saveProductEntry(ProductEntryDTO productEntryDTO);
	public List<ProductEntry> getAll();
}
