package com.grupo11tpc.tpc.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo11tpc.tpc.entities.SupplyOrder;

public interface ISupplyOrderRepository extends JpaRepository<SupplyOrder, Serializable> {

}
