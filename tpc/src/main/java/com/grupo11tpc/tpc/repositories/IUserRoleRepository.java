package com.grupo11tpc.tpc.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo11tpc.tpc.entities.UserRole;

@Repository("userRoleRepository")
//Creado solo para guardar los roles en la bd
public interface IUserRoleRepository extends JpaRepository<UserRole, Serializable> {

}
