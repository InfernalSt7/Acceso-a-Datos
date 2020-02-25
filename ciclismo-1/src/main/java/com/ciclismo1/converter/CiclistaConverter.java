package com.ciclismo1.converter;

import org.springframework.stereotype.Component;

import com.ciclismo1.entity.Ciclista;
import com.ciclismo1.model.CiclistaModel;

@Component("ciclistaConverter")
public class CiclistaConverter {
	
	//Entity --> Model
	public CiclistaModel entity2model(Ciclista ciclista) {
		CiclistaModel ciclistaModel=new CiclistaModel();
		ciclistaModel.setDorsal(ciclista.getDorsal());
		ciclistaModel.setNombre(ciclista.getNombre());
		ciclistaModel.setEdad(ciclista.getEdad());
		ciclistaModel.setEquipo(ciclista.getEquipo());
		return ciclistaModel;
	}
	
	public Ciclista model2entity(CiclistaModel ciclistaModel) {
		Ciclista ciclista=new Ciclista();
		ciclista.setDorsal(ciclistaModel.getDorsal());
		ciclista.setNombre(ciclistaModel.getNombre());
		ciclista.setEdad(ciclistaModel.getEdad());
		ciclista.setEquipo(ciclistaModel.getEquipo());
		return ciclista;
	}
	

}
