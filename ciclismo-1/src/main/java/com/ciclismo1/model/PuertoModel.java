package com.ciclismo1.model;

import com.ciclismo1.entity.Ciclista;
import com.ciclismo1.entity.Etapa;

public class PuertoModel {
	
	private String nompuerto;
	private int altura;
	private String categoria;
	private int pendiente;
	private Etapa etapa;
	private Ciclista ciclista;
	
	
	public PuertoModel(String nompuerto, int altura, String categoria, int pendiente, Etapa etapa, Ciclista ciclista) {
		super();
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
		this.etapa = etapa;
		this.ciclista = ciclista;
	}


	public PuertoModel() {}


	public String getNompuerto() {
		return nompuerto;
	}


	public void setNompuerto(String nompuerto) {
		this.nompuerto = nompuerto;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getPendiente() {
		return pendiente;
	}


	public void setPendiente(int pendiente) {
		this.pendiente = pendiente;
	}


	public Etapa getEtapa() {
		return etapa;
	}


	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}


	public Ciclista getCiclista() {
		return ciclista;
	}


	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}
	
	
}
