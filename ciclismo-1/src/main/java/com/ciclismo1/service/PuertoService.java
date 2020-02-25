package com.ciclismo1.service;

import java.util.List;

import com.ciclismo1.entity.Puerto;
import com.ciclismo1.model.PuertoModel;

public interface PuertoService {
	
	public abstract List<PuertoModel> listAllPuertos();
	public abstract Puerto addPuerto(PuertoModel puertoModel);
	public abstract int removePuerto(String nompuerto);
	public abstract Puerto updatePuerto(PuertoModel puertoModel);
	
}
