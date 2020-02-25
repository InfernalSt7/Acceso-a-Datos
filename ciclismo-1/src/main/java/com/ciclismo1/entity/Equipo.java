package com.ciclismo1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ciclismo1.entity.Ciclista;

@Entity
@Table(name="equipo")
public class Equipo {
	
	@Id
	@Column(name="nomeq")
	private String nomeq;
	
	@Column(name="director")
	@NotNull
	private String director;
	
	@Column(name="logo")
	@NotNull
	private String logo;
	
	@OneToMany(mappedBy="equipo")
	private List<Ciclista> Ciclistas;

	public Equipo(String nomeq, @NotNull String director, @NotNull String logo, List<Ciclista> ciclistas) {
		super();
		this.nomeq = nomeq;
		this.director = director;
		this.logo = logo;
		Ciclistas = ciclistas;
	}

	public Equipo() {}

	public String getNomeq() {
		return nomeq;
	}

	public void setNomeq(String nomeq) {
		this.nomeq = nomeq;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Ciclista> getCiclistas() {
		return Ciclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		Ciclistas = ciclistas;
	}
		
	
}
