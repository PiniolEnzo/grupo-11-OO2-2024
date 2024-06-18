package com.grupo11tpc.tpc.entities; 

import java.time.LocalDateTime; 

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne; 

import lombok.Data; 
import lombok.Getter; 
import lombok.NoArgsConstructor; 
import lombok.Setter; 

@Entity 
@Data 
@Getter 
@Setter 
@NoArgsConstructor 
public class SupplyOrder { 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id; 
	@Column(name="requested_amount") 
	private int requestedAmount; 
	@CreationTimestamp 
	@Column(name="requested_at") 
	private LocalDateTime requestedAt; 
	@ManyToOne 
	@JoinColumn(name="product_id") 
	private Product product; 
	@ManyToOne 
	@JoinColumn(name="supplier_id") 
	private Supplier supplier; 
	
}