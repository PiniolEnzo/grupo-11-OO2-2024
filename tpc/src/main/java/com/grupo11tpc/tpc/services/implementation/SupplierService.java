package com.grupo11tpc.tpc.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo11tpc.tpc.entities.Supplier;
import com.grupo11tpc.tpc.repositories.ISupplierRepository;
import com.grupo11tpc.tpc.services.ISupplierService;

@Service
public class SupplierService implements ISupplierService {
	
	private ISupplierRepository supplierRepository;
	
	public SupplierService(ISupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	@Override
	public Optional<Supplier> findById(int supplierId) {
		return supplierRepository.findById(supplierId);
	}

	@Override
	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}
	
	

}
