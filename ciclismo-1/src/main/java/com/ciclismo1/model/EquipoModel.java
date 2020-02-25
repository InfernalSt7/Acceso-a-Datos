package com.ciclismo1.model;

import java.util.List;

import com.ciclismo1.model.CiclistaModel;

public class EquipoModel {
	private String nomeq;
	private String director;
	private String logo;
	private List<CiclistaModel> Ciclistas;
	public EquipoModel(String nomeq, String director, String logo, List<CiclistaModel> ciclistas) {
		super();
		this.nomeq = nomeq;
		this.director = director;
		this.logo = logo;
		Ciclistas = ciclistas;
	}
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
	public List<CiclistaModel> getCiclistas() {
		return Ciclistas;
	}
	public void setCiclistas(List<CiclistaModel> ciclistas) {
		Ciclistas = ciclistas;
	}
	
	public EquipoModel() {}
	
	
	
	
}
