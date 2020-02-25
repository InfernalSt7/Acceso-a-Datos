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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ciclismo1.entity.Llevar;
import com.ciclismo1.entity.Puerto;

@Entity
@Table(name="etapa")
public class Etapa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="netapa")
	private int netapa;
	
	@Column(name="km")
	private int km;
	
	@Column(name="salida")
	private String salida;
	
	@Column(name="llegada")
	private String llegada;
	
	@ManyToOne
	@JoinColumn(name="dorsal")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Ciclista ciclista;

	@OneToMany(mappedBy="etapa", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Puerto> Puertos;
	
	@OneToMany(mappedBy="etapa", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Llevar> Llevar;
	
	public Etapa(int netapa, int km, String salida, String llegada, Ciclista ciclista) {
		super();
		this.netapa = netapa;
		this.km = km;
		this.salida = salida;
		this.llegada = llegada;
		this.ciclista = ciclista;
	}

	public Etapa() {}

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

	
	
}
