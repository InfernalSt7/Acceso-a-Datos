package com.ciclismo1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclismo1.entity.Puerto;

@Repository("puertoJpaRepository")
public interface PuertoJpaRepository extends JpaRepository<Puerto, Serializable>{

}
