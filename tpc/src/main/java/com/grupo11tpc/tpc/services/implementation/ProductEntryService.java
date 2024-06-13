package com.grupo11tpc.tpc.services.implementation;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.grupo11tpc.tpc.entities.ProductEntry;
import com.grupo11tpc.tpc.repositories.IProductEntryRepository;
import com.grupo11tpc.tpc.services.IProductEntryService;

@Service
public class ProductEntryService implements IProductEntryService {
	
	private IProductEntryRepository productEntryRepository;
	
	public ProductEntryService(IProductEntryRepository productEntryRepository) {
		this.productEntryRepository = productEntryRepository;
	}

	//Alta de nuevo lote de stock de un producto de la organización.
	@Override
	public void saveProductEntry(int receivedAmount, long purchasePrice) {
		ProductEntry productEntry = new ProductEntry();
		productEntry.setReceivedAmount(receivedAmount);
		productEntry.setReceivedAt(LocalDateTime.now());
		productEntry.setPurchasePrice(purchasePrice);
		productEntryRepository.save(productEntry);
	}

}
