package com.ciclismo1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="puerto")
public class Puerto {
	
	@Id
	@Column(name="nompuerto")
	private String nompuerto;
	
	@Column(name="altura")
	private int altura;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="pendiente")
	private int pendiente;
	
	@ManyToOne
	@JoinColumn(name="netapa")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Etapa etapa;
	
	@ManyToOne
	@JoinColumn(name="dorsal")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Ciclista ciclista;

	public Puerto(String nompuerto, int altura, String categoria, int pendiente, Etapa etapa, Ciclista ciclista) {
		super();
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
		this.etapa = etapa;
		this.ciclista = ciclista;
	}

	public Puerto() {}

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
