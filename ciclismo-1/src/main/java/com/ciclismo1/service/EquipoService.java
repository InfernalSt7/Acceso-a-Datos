package com.ciclismo1.service;

import java.util.List;

import com.ciclismo1.entity.Equipo;
import com.ciclismo1.model.EquipoModel;

public interface EquipoService {
	
	public abstract List<EquipoModel> listAllEquipos();
	public abstract Equipo addEquipo(EquipoModel equipoModel);
	public abstract int removeEquipo(String nomeq);
	public abstract Equipo updateEquipo(EquipoModel equipoModel);
	
}
