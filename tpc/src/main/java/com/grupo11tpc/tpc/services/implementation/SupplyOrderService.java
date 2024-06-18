package com.grupo11tpc.tpc.services.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo11tpc.tpc.dtos.SupplyOrderDTO;
import com.grupo11tpc.tpc.entities.Product;
import com.grupo11tpc.tpc.entities.Supplier;
import com.grupo11tpc.tpc.entities.SupplyOrder;
import com.grupo11tpc.tpc.repositories.IProductRepository;
import com.grupo11tpc.tpc.repositories.ISupplierRepository;
import com.grupo11tpc.tpc.repositories.ISupplyOrderRepository;
import com.grupo11tpc.tpc.services.ISupplyOrderService;

@Service("supplyOrderService")
public class SupplyOrderService implements ISupplyOrderService {
	private ISupplyOrderRepository supplyOrderRepository;
	private IProductRepository productRepository;
	private ISupplierRepository supplierRepository;
	
	@Override
	public List<SupplyOrder> getAll() {
		
		return supplyOrderRepository.findAll();
	}

	@Override
	public void insert(SupplyOrderDTO supplyOrderDTO){
		Product prod = productRepository.findById(supplyOrderDTO.getProductId()).orElseThrow();
		Supplier sup = supplierRepository.findById(supplyOrderDTO.getSupplierId()).orElseThrow();
		
		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setRequestedAmount(supplyOrderDTO.getRequestedAmount());
		supplyOrder.setRequestedAt(LocalDateTime.now());
		supplyOrder.setProduct(prod);
		supplyOrder.setSupplier(sup);
		
		supplyOrderRepository.save(supplyOrder);
	}

}
