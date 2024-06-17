package com.grupo11tpc.tpc.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	private String description;

//	private List<String> categories = new ArrayList<>();

	private int amount;

	private double purchaseCost;

	private double salePrice;

	public Product(long id, String name, String description, int amount, double purchaseCost, double salePrice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
//		this.categories = categories;
		this.amount = amount;
		this.purchaseCost = purchaseCost;
		this.salePrice = salePrice;
	}

}
