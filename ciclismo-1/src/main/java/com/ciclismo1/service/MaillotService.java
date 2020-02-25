package com.ciclismo1.service;

import java.util.List;

import com.ciclismo1.entity.Maillot;
import com.ciclismo1.model.MaillotModel;

public interface MaillotService {
	
	public abstract List<MaillotModel> listAllMaillots();
	public abstract Maillot addMaillot(MaillotModel maillotModel);
	public abstract int removeMaillot(String codigo);
	public abstract Maillot updateMaillot(MaillotModel maillotModel);
	
}
