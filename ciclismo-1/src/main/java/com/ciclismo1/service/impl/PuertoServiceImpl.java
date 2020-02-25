package com.ciclismo1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ciclismo1.converter.PuertoConverter;
import com.ciclismo1.entity.Puerto;
import com.ciclismo1.model.PuertoModel;
import com.ciclismo1.repository.PuertoJpaRepository;
import com.ciclismo1.service.PuertoService;

@Service("puertoServiceImpl")
public class PuertoServiceImpl implements PuertoService {
	
	@Autowired
	@Qualifier("puertoJpaRepository")
	private PuertoJpaRepository puertoJpaRepository;
	
	@Autowired
	@Qualifier("puertoConverter")
	private PuertoConverter puertoConverter;

	@Override
	public List<PuertoModel> listAllPuertos() {
		List<PuertoModel> puertoModel=new ArrayList<PuertoModel>();
		for(Puerto puerto: puertoJpaRepository.findAll())
			puertoModel.add(puertoConverter.entity2model(puerto));
		return puertoModel;
	}

	@Override
	public Puerto addPuerto(PuertoModel puertoModel) {
		Puerto puerto=puertoConverter.model2entity(puertoModel);
		return puertoJpaRepository.save(puerto);
	}

 
	@Override
	public Puerto updatePuerto(PuertoModel puertoModel) {
		Puerto puerto=puertoConverter.model2entity(puertoModel);
		return puertoJpaRepository.save(puerto);
	}

	@Override
	public int removePuerto(String nompuerto) {
		puertoJpaRepository.deleteById(nompuerto);
		return 0;
	}
}
