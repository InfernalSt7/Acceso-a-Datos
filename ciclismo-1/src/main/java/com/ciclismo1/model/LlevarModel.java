package com.ciclismo1.model;

import com.ciclismo1.entity.Ciclista;
import com.ciclismo1.entity.Etapa;
import com.ciclismo1.entity.Maillot;

public class LlevarModel {
	
	private int id;
	private Ciclista ciclista;
	private Etapa etapa;
	private Maillot maillot;
	
	public LlevarModel(int id, Ciclista ciclista, Etapa etapa, Maillot maillot) {
		super();
		this.id = id;
		this.ciclista = ciclista;
		this.etapa = etapa;
		this.maillot = maillot;
	}

	public LlevarModel() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Maillot getMaillot() {
		return maillot;
	}

	public void setMaillot(Maillot maillot) {
		this.maillot = maillot;
	}
	
	

}
