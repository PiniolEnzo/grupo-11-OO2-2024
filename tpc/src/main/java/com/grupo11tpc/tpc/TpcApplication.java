package com.grupo11tpc.tpc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.grupo11tpc.tpc.entities.Supplier;
import com.grupo11tpc.tpc.entities.User;
import com.grupo11tpc.tpc.entities.UserRole;
import com.grupo11tpc.tpc.repositories.ISupplierRepository;
import com.grupo11tpc.tpc.repositories.IUserRepository;
import com.grupo11tpc.tpc.repositories.IUserRoleRepository;

@SpringBootApplication
public class TpcApplication implements CommandLineRunner {
	
	private ISupplierRepository supplierRepository;
	private IUserRepository userRepository;
	private IUserRoleRepository userRoleRepository;

	public TpcApplication(ISupplierRepository supplierRepository, IUserRepository userRepository,
			IUserRoleRepository userRoleRepository) {
		super();
		this.supplierRepository = supplierRepository;
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
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
		if(userRepository.findAll().isEmpty()) {
			//Para encriptar la pass
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			//Variable que voy a utilizar en la creacion de usuarios
			LocalDateTime now = LocalDateTime.now();
			
			//Roles del admin
			Set<UserRole> adminRoles = new HashSet<UserRole>();
			//Roles del usuario
			Set<UserRole> userRoles = new HashSet<UserRole>();
			
			//Se crea el primer rol, para admin
			UserRole adminRole = new UserRole();
			adminRole.setRole("ROLE_ADMIN");
			adminRole.setCreatedAt(now);
			adminRole.setUpdatedAt(now);
			
			//Se crea el segundo rol, para usuario
			UserRole userRole = new UserRole();
			userRole.setRole("ROLE_USER");
			userRole.setCreatedAt(now);
			userRole.setUpdatedAt(now);
			
			//Se crean las credenciales de ambos usuarios, y se encriptan las claves
			User normalUser = new User("user",bcrypt.encode("userPass"),true);
			User adminUser = new User("admin",bcrypt.encode("adminPass"),true);
			
			//Se agrega el usuario adminUser al adminRole
			adminRole.setUser(adminUser);
			//Se agrega el usuario normalUser al userRole
			userRole.setUser(normalUser);
			
			//Se agreguan los roles a sus set correspondientes
			adminRoles.add(adminRole);
			userRoles.add(userRole);
			
			//Se agregan los roles a los usuarios
			normalUser.setUserRoles(userRoles);
			adminUser.setUserRoles(adminRoles);
			
			//Se guardan ambos usuarios.
			userRepository.save(adminUser);
			userRepository.save(normalUser);
			
			//Se guardan ambos roles
			userRoleRepository.save(adminRole);
			userRoleRepository.save(userRole);
			
	
		}
		
	}

}
