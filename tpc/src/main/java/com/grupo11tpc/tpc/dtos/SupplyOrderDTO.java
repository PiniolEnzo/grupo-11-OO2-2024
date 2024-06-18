package com.grupo11tpc.tpc.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SupplyOrderDTO{ 
	private long id;  
	private int requestedAmount; 
	private LocalDateTime requestedAt; 
	private int productId;
	private int supplierId;
}