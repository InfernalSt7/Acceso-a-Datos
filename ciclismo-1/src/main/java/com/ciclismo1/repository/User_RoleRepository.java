package com.ciclismo1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclismo1.entity.User_Role;

@Repository("userRoleRepository")
public interface User_RoleRepository extends JpaRepository <User_Role, Serializable>{
	public abstract User_Role findByUser (String user);
}
