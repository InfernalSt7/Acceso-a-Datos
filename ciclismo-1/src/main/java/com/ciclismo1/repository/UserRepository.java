package com.ciclismo1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclismo1.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository <User, Serializable>{
	public abstract User findByUsername(String username);
}
