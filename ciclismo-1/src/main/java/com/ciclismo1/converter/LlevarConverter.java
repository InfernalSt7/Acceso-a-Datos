package com.ciclismo1.converter;

import org.springframework.stereotype.Component;

import com.ciclismo1.entity.Llevar;
import com.ciclismo1.model.LlevarModel;

@Component("llevarConverter")
public class LlevarConverter {
	
	//Entity --> Model
	public LlevarModel entity2model(Llevar llevar) {
		LlevarModel llevarModel=new LlevarModel();
		llevarModel.setId(llevar.getId());
		llevarModel.setCiclista(llevar.getCiclista());
		llevarModel.setEtapa(llevar.getEtapa());
		llevarModel.setMaillot(llevar.getMaillot());
		return llevarModel;
	}
	
	public Llevar model2entity(LlevarModel llevarModel) {
		Llevar llevar=new Llevar();
		llevar.setId(llevarModel.getId());
		llevar.setCiclista(llevarModel.getCiclista());
		llevar.setEtapa(llevar.getEtapa());
		llevar.setMaillot(llevar.getMaillot());
		return llevar;
	}
	

}
