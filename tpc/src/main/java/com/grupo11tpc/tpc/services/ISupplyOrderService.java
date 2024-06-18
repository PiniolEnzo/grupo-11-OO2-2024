package com.grupo11tpc.tpc.services;

import java.util.List;

import com.grupo11tpc.tpc.dtos.SupplyOrderDTO;
import com.grupo11tpc.tpc.entities.SupplyOrder;

public interface ISupplyOrderService {
	public void insert(SupplyOrderDTO supplyOrderDTO);
	public List<SupplyOrder> getAll();
}
