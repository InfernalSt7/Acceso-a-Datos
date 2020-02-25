package com.ciclismo1.converter;

import org.springframework.stereotype.Component;

import com.ciclismo1.entity.Maillot;
import com.ciclismo1.model.MaillotModel;

@Component("maillotConverter")
public class MaillotConverter {
	
	//Entity --> Model
	public MaillotModel entity2model(Maillot maillot) {
		MaillotModel maillotModel=new MaillotModel();
		maillotModel.setCodigo(maillot.getCodigo());
		maillotModel.setTipo(maillot.getTipo());
		maillotModel.setColor(maillot.getColor());
		maillotModel.setPremio(maillot.getPremio());
		return maillotModel;
	}
	
	public Maillot model2entity(MaillotModel maillotModel) {
		Maillot maillot=new Maillot();
		maillot.setCodigo(maillotModel.getCodigo());
		maillot.setTipo(maillotModel.getTipo());
		maillot.setColor(maillotModel.getColor());
		maillot.setPremio(maillotModel.getPremio());
		return maillot;
	}
	

}
