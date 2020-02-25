package com.ciclismo1.model;

import java.util.List;

import com.ciclismo1.model.LlevarModel;

public class MaillotModel {
	
	private String codigo;
	private String tipo;
	private String color;
	private int premio;
	private List<LlevarModel> Llevar;
	public MaillotModel(String codigo, String tipo, String color, int premio, List<LlevarModel> llevar) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.color = color;
		this.premio = premio;
		Llevar = llevar;
	}
	public MaillotModel() {}
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
	public List<LlevarModel> getLlevar() {
		return Llevar;
	}
	public void setLlevar(List<LlevarModel> llevar) {
		Llevar = llevar;
	}
	
	
	
	
	
}
