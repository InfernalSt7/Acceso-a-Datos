package com.ciclismo1.converter;

import org.springframework.stereotype.Component;

import com.ciclismo1.entity.Equipo;
import com.ciclismo1.model.EquipoModel;

@Component("equipoConverter")
public class EquipoConverter {
	
	//Entity --> Model
	public EquipoModel entity2model(Equipo equipo) {
		EquipoModel equipoModel=new EquipoModel();
		equipoModel.setNomeq(equipo.getNomeq());
		equipoModel.setLogo(equipo.getLogo());
		equipoModel.setDirector(equipo.getDirector());
		return equipoModel;
	}
	
	public Equipo model2entity(EquipoModel equipoModel) {
		Equipo equipo=new Equipo();
		equipo.setNomeq(equipoModel.getNomeq());
		equipo.setLogo(equipoModel.getLogo());
		equipo.setDirector(equipoModel.getDirector());
		return equipo;
	}
	

}
