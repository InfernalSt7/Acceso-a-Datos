package com.ciclismo1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="llevar")
public class Llevar {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="id")
	 private int id;
	 
	 @ManyToOne
	 @JoinColumn(name="dorsal")
	 @OnDelete(action=OnDeleteAction.CASCADE)
	 private Ciclista ciclista;
	 
	 @ManyToOne
	 @JoinColumn(name="netapa")
	 @OnDelete(action=OnDeleteAction.CASCADE)
	 private Etapa etapa;
	 
	 @ManyToOne
	 @JoinColumn(name="codigo")
	 @OnDelete(action=OnDeleteAction.NO_ACTION)
	 private Maillot maillot;

	public Llevar(int id, Ciclista ciclista, Etapa etapa, Maillot maillot) {
		super();
		this.id = id;
		this.ciclista = ciclista;
		this.etapa = etapa;
		this.maillot = maillot;
	}

	public Llevar() {}

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
