package com.ciclismo1.model;

import java.util.List;

import com.ciclismo1.entity.Equipo;

import com.ciclismo1.model.EtapaModel;
import com.ciclismo1.model.LlevarModel;
import com.ciclismo1.model.PuertoModel;

public class CiclistaModel {

	private int dorsal;
	private String nombre;
	private String foto;
	private int edad;
	private Equipo equipo;
	private List<EtapaModel> Etapas;
	
	private List<PuertoModel> Puertos;
	
	private List<LlevarModel> Llevar;

	public CiclistaModel(int dorsal, String nombre, String foto, int edad, Equipo equipo, List<EtapaModel> etapas,
			List<PuertoModel> puertos, List<LlevarModel> llevar) {
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

	public CiclistaModel() {}

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

	public List<EtapaModel> getEtapas() {
		return Etapas;
	}

	public void setEtapas(List<EtapaModel> etapas) {
		Etapas = etapas;
	}

	public List<PuertoModel> getPuertos() {
		return Puertos;
	}

	public void setPuertos(List<PuertoModel> puertos) {
		Puertos = puertos;
	}

	public List<LlevarModel> getLlevar() {
		return Llevar;
	}

	public void setLlevar(List<LlevarModel> llevar) {
		Llevar = llevar;
	}
	
	
	
	
}
