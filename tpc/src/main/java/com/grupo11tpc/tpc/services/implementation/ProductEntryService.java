package com.grupo11tpc.tpc.services.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo11tpc.tpc.dtos.ProductEntryDTO;
import com.grupo11tpc.tpc.entities.Product;
import com.grupo11tpc.tpc.entities.ProductEntry;
import com.grupo11tpc.tpc.entities.Supplier;
import com.grupo11tpc.tpc.repositories.IProductEntryRepository;
import com.grupo11tpc.tpc.repositories.IProductRepository;
import com.grupo11tpc.tpc.repositories.ISupplierRepository;
import com.grupo11tpc.tpc.services.IProductEntryService;

@Service("productEntryService")
public class ProductEntryService implements IProductEntryService {
	
	private IProductEntryRepository productEntryRepository;
	private IProductRepository productRepository;
	private ISupplierRepository supplierRepository;
	
	public ProductEntryService(IProductEntryRepository productEntryRepository, IProductRepository productRepository,
			ISupplierRepository supplierRepository) {
		this.productEntryRepository = productEntryRepository;
		this.productRepository = productRepository;
		this.supplierRepository = supplierRepository;
	}

	//Alta de nuevo lote de stock de un producto de la organización.
	@Override
	public void saveProductEntry(ProductEntryDTO productEntryDTO) {
		//Primero verifico que existan el producto y proveedor
		Product pr = productRepository.findById(productEntryDTO.getProductId()).orElseThrow();
		Supplier sup = supplierRepository.findById(productEntryDTO.getSupplierId()).orElseThrow();
		
		ProductEntry productEntry = new ProductEntry();
		productEntry.setReceivedAmount(productEntryDTO.getReceivedAmount());
		productEntry.setReceivedAt(LocalDateTime.now());
		productEntry.setPurchasePrice(productEntryDTO.getPurchasePrice());
		
		//Se agrega la cantidad recibida al producto
		pr.setAmount(pr.getAmount()+productEntryDTO.getReceivedAmount());
		
		productEntry.setProduct(pr);
		productEntry.setSupplier(sup);
		
		//Se guarda el producto actualizado
		productRepository.save(pr);
		productEntryRepository.save(productEntry);
	}

	@Override
	public List<ProductEntry> getAll() {
		return productEntryRepository.findAll();
	}

}
