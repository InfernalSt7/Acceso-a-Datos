package com.ciclismo1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ciclismo1.entity.Etapa;
import com.ciclismo1.entity.Llevar;
import com.ciclismo1.entity.Puerto;

@Entity
@Table(name="ciclista")
public class Ciclista {
	
	@Id	
	@Column(name="dorsal")
	private int dorsal;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="edad")
	private int edad;
	
	@ManyToOne
	@JoinColumn(name="nomeq")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Equipo equipo;
	
	@OneToMany(mappedBy="ciclista", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Etapa> Etapas;
	
	@OneToMany(mappedBy="ciclista", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Puerto> Puertos;
	
	@OneToMany(mappedBy="ciclista", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Llevar> Llevar;

	
	public Ciclista(int dorsal, String nombre, String foto, int edad, Equipo equipo, List<Etapa> etapas,
			List<Puerto> puertos, List<com.ciclismo1.entity.Llevar> llevar) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.foto = foto;
		this.edad = edad;
		this.equipo = equipo;
		Etapas = etapas;
		Puertos = puertos;
		Llevar = llevar;
	}
	
	

	public Ciclista() {}




	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Etapa> getEtapas() {
		return Etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		Etapas = etapas;
	}

	public List<Puerto> getPuertos() {
		return Puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		Puertos = puertos;
	}

	public List<Llevar> getLlevar() {
		return Llevar;
	}

	public void setLlevar(List<Llevar> llevar) {
		Llevar = llevar;
	}

	
	

	

	

	

		
	
}
