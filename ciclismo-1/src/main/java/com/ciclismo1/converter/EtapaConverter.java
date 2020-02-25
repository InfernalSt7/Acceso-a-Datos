package com.ciclismo1.converter;

import org.springframework.stereotype.Component;

import com.ciclismo1.entity.Etapa;
import com.ciclismo1.model.EtapaModel;

@Component("etapaConverter")
public class EtapaConverter {
	
	//Entity --> Model
	public EtapaModel entity2model(Etapa etapa) {
		EtapaModel etapaModel=new EtapaModel();
		etapaModel.setNetapa(etapa.getNetapa());
		etapaModel.setKm(etapa.getKm());
		etapaModel.setSalida(etapa.getSalida());
		etapaModel.setLlegada(etapa.getLlegada());
		etapaModel.setCiclista(etapa.getCiclista());
		return etapaModel;
	}
	
	public Etapa model2entity(EtapaModel etapaModel) {
		Etapa etapa=new Etapa();
		etapa.setNetapa(etapaModel.getNetapa());
		etapa.setKm(etapaModel.getKm());
		etapa.setSalida(etapaModel.getSalida());
		etapa.setLlegada(etapaModel.getLlegada());
		etapa.setCiclista(etapaModel.getCiclista());
		return etapa;
	}
	

}
