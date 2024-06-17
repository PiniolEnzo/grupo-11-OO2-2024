package com.grupo11tpc.tpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupo11tpc.tpc.entities.Supplier;
import com.grupo11tpc.tpc.repositories.ISupplierRepository;

@SpringBootApplication
public class TpcApplication implements CommandLineRunner {
	
	private ISupplierRepository supplierRepository;

	public TpcApplication(ISupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TpcApplication.class, args);
	}

	//Esto es para poder hacer operaciones ni bien se inicia la app
	@Override
	public void run(String... args) throws Exception {
		if(supplierRepository.findAll().isEmpty()) {
			supplierRepository.save(new Supplier(0,"Jose","Sanchez","+541160612010"));
			supplierRepository.save(new Supplier(0,"Fernando","Gimenez","+541130314085"));
			supplierRepository.save(new Supplier(0,"Romina","Fernandez","+541120513124"));
		}
		
	}

}
