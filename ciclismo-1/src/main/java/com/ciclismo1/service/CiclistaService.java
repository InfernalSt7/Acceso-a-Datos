package com.ciclismo1.service;

import java.util.List;

import com.ciclismo1.entity.Ciclista;
import com.ciclismo1.model.CiclistaModel;

public interface CiclistaService {
	
	public abstract List<CiclistaModel> listAllCiclistas();
	public abstract Ciclista addCiclista(CiclistaModel ciclistaModel);
	public abstract int removeCiclista(int dorsal);
	public abstract Ciclista updateCiclista(CiclistaModel ciclistaModel);
	
}
