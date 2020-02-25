package com.ciclismo1.service;

import java.util.List;

import com.ciclismo1.entity.Etapa;
import com.ciclismo1.model.EtapaModel;

public interface EtapaService {
	
	public abstract List<EtapaModel> listAllEtapas();
	public abstract Etapa addEtapa(EtapaModel etapaModel);
	public abstract int removeEtapa(String netapa);
	public abstract Etapa updateEtapa(EtapaModel etapaModel);
	
}
