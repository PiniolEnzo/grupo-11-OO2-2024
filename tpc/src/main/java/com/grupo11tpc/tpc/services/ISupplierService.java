package com.grupo11tpc.tpc.services;

import java.util.Optional;

import com.grupo11tpc.tpc.entities.Supplier;

public interface ISupplierService {
	public Optional<Supplier> findById(int supplierId);
}
