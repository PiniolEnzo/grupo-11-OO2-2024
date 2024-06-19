package com.grupo11tpc.tpc.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo11tpc.tpc.entities.SupplyOrder;

@Repository("supplyOrderRepository")
public interface ISupplyOrderRepository extends JpaRepository<SupplyOrder, Serializable> {
	
}
