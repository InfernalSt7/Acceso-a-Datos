package com.ciclismo1.model;

import java.util.List;

import com.ciclismo1.entity.Ciclista;

import com.ciclismo1.model.LlevarModel;
import com.ciclismo1.model.PuertoModel;

public class EtapaModel {
	
	private int netapa;
	private int km;
	private String salida;
	private String llegada;
	private Ciclista ciclista;
	private List<PuertoModel> Puertos;
	private List<LlevarModel> Llevar;
	
	public EtapaModel(int netapa, int km, String salida, String llegada, Ciclista ciclista, List<PuertoModel> puertos,
			List<LlevarModel> llevar) {
		super();
		this.netapa = netapa;
		this.km = km;
		this.salida = salida;
		this.llegada = llegada;
		this.ciclista = ciclista;
		Puertos = puertos;
		Llevar = llevar;
	}

	public EtapaModel() {}

	public int getNetapa() {
		return netapa;
	}

	public void setNetapa(int netapa) {
		this.netapa = netapa;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
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
