package com.grupo11tpc.tpc.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo11tpc.tpc.entities.Supplier;

@Repository("supplierRepository")
public interface ISupplierRepository  extends JpaRepository<Supplier, Serializable> {

}
