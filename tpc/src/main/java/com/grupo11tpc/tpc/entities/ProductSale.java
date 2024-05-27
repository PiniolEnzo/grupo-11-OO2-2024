package com.grupo11tpc.tpc.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter 
@NoArgsConstructor
public class ProductSale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private LocalDate saleDate;
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="product_id")
	//private Product product;
}
