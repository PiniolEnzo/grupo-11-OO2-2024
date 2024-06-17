package com.grupo11tpc.tpc.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ProductDTO {
	private long id;
	private String name;
	private int amount;
	private int minimalAmount;
	private String description;
	private double salePrice;
}
