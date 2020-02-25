package com.ciclismo1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ciclismo1.entity.Llevar;

@Entity
@Table(name="maillot")
public class Maillot {

	@Id	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="color")
	private String color;
	
	@Column(name="premio")
	private int premio;
	
	@OneToMany(mappedBy="maillot", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Llevar> Llevar;

	public Maillot(String codigo, String tipo, String color, int premio, List<com.ciclismo1.entity.Llevar> llevar) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.color = color;
		this.premio = premio;
		Llevar = llevar;
	}

	public Maillot() {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	public List<Llevar> getLlevar() {
		return Llevar;
	}

	public void setLlevar(List<Llevar> llevar) {
		Llevar = llevar;
	}
	
		
	
}
