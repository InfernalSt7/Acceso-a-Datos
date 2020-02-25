package com.ciclismo1.converter;

import org.springframework.stereotype.Component;

import com.ciclismo1.entity.Puerto;
import com.ciclismo1.model.PuertoModel;

@Component("puertoConverter")
public class PuertoConverter {
	
	//Entity --> Model
	public PuertoModel entity2model(Puerto puerto) {
		PuertoModel puertoModel=new PuertoModel();
		puertoModel.setNompuerto(puerto.getNompuerto());
		puertoModel.setAltura(puerto.getAltura());
		puertoModel.setCategoria(puerto.getCategoria());
		puertoModel.setPendiente(puerto.getPendiente());
		puertoModel.setEtapa(puerto.getEtapa());
		puertoModel.setCiclista(puerto.getCiclista());
		return puertoModel;
	}
	
	public Puerto model2entity(PuertoModel puertoModel) {
		Puerto puerto=new Puerto();
		puerto.setNompuerto(puertoModel.getNompuerto());
		puerto.setAltura(puertoModel.getAltura());
		puerto.setCategoria(puerto.getCategoria());
		puerto.setPendiente(puerto.getPendiente());
		puerto.setEtapa(puerto.getEtapa());
		puerto.setCiclista(puerto.getCiclista());
		return puerto;
	}
	

}
