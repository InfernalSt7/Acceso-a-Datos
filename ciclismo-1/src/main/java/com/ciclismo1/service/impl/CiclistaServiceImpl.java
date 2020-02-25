package com.ciclismo1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ciclismo1.converter.CiclistaConverter;
import com.ciclismo1.entity.Ciclista;
import com.ciclismo1.model.CiclistaModel;
import com.ciclismo1.repository.CiclistaJpaRepository;
import com.ciclismo1.service.CiclistaService;
@Service("ciclistaServiceImpl")
public class CiclistaServiceImpl implements CiclistaService {
	
	@Autowired
	@Qualifier("ciclistaJpaRepository")
	private CiclistaJpaRepository ciclistaJpaRepository;
	
	@Autowired
	@Qualifier("ciclistaConverter")
	private CiclistaConverter ciclistaConverter;
	
	@Override
	public List<CiclistaModel> listAllCiclistas() {
		List<CiclistaModel> ciclistaModel=new ArrayList<CiclistaModel>();
		for(Ciclista ciclista: ciclistaJpaRepository.findAll())
			ciclistaModel.add(ciclistaConverter.entity2model(ciclista));
		return ciclistaModel;
	}

	@Override
	public Ciclista addCiclista(CiclistaModel ciclistaModel) {
		Ciclista ciclista=ciclistaConverter.model2entity(ciclistaModel);
		return ciclistaJpaRepository.save(ciclista);
	}

 
	@Override
	public Ciclista updateCiclista(CiclistaModel ciclistaModel) {
		Ciclista ciclista=ciclistaConverter.model2entity(ciclistaModel);
		return ciclistaJpaRepository.save(ciclista);
	}

	@Override
	public int removeCiclista(int dorsal) {
		ciclistaJpaRepository.deleteById(dorsal);
		return 0;
	}
}
