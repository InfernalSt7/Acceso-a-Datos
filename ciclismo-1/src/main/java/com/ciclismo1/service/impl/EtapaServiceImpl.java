package com.ciclismo1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ciclismo1.converter.EtapaConverter;
import com.ciclismo1.entity.Etapa;
import com.ciclismo1.model.EtapaModel;
import com.ciclismo1.repository.EtapaJpaRepository;
import com.ciclismo1.service.EtapaService;

@Service("etapaServiceImpl")
public class EtapaServiceImpl implements EtapaService {
	
	@Autowired
	@Qualifier("etapaJpaRepository")
	private EtapaJpaRepository etapaJpaRepository;
	
	@Autowired
	@Qualifier("etapaConverter")
	private EtapaConverter etapaConverter;

	@Override
	public List<EtapaModel> listAllEtapas() {
		List<EtapaModel> etapaModel=new ArrayList<EtapaModel>();
		for(Etapa etapa: etapaJpaRepository.findAll())
			etapaModel.add(etapaConverter.entity2model(etapa));
		return etapaModel;
	}

	@Override
	public Etapa addEtapa(EtapaModel etapaModel) {
		Etapa etapa=etapaConverter.model2entity(etapaModel);
		return etapaJpaRepository.save(etapa);
	}

 
	@Override
	public Etapa updateEtapa(EtapaModel etapaModel) {
		Etapa etapa=etapaConverter.model2entity(etapaModel);
		return etapaJpaRepository.save(etapa);
	}

	@Override
	public int removeEtapa(String netapa) {
		etapaJpaRepository.deleteById(netapa);
		return 0;
	}
}
