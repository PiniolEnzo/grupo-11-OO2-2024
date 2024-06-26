package com.grupo11tpc.tpc.services;

import java.util.List;
import java.util.Optional;

import com.grupo11tpc.tpc.entities.Supplier;

public interface ISupplierService {
	public Optional<Supplier> findById(int supplierId);
	public List<Supplier> getAll();
	public Supplier insertOrUpdate(Supplier supplier);
	public boolean remove(int id);
}
