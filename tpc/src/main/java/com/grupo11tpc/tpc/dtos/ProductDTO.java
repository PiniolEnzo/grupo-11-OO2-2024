package com.grupo11tpc.tpc.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProductDTO {
	private long id;
	private String name;
	private String description;
	private double salePrice;
	
	
	public ProductDTO(long id, String name, String description, double salePrice) {
		super();
		this.setId(id);
		this.name = name;
		this.description = description;
		this.salePrice = salePrice;
	}
}
