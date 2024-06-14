package com.grupo11tpc.tpc.dtos;

import lombok.Data;

@Data
public class ProductEntryDTO {
	private int id;
	private int receivedAmount;
	private long purchasePrice;
	private int productId;
	private int supplierId;
}
