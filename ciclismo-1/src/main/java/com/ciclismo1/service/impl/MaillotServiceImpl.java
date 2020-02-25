package com.ciclismo1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ciclismo1.converter.MaillotConverter;
import com.ciclismo1.entity.Maillot;
import com.ciclismo1.model.MaillotModel;
import com.ciclismo1.repository.MaillotJpaRepository;
import com.ciclismo1.service.MaillotService;

@Service("maillotServiceImpl")
public class MaillotServiceImpl implements MaillotService {
	
	@Autowired
	@Qualifier("maillotJpaRepository")
	private MaillotJpaRepository maillotJpaRepository;
	
	@Autowired
	@Qualifier("maillotConverter")
	private MaillotConverter maillotConverter;

	@Override
	public List<MaillotModel> listAllMaillots() {
		List<MaillotModel> maillotModel=new ArrayList<MaillotModel>();
		for(Maillot maillot: maillotJpaRepository.findAll())
			maillotModel.add(maillotConverter.entity2model(maillot));
		return maillotModel;
	}

	@Override
	public Maillot addMaillot(MaillotModel maillotModel) {
		Maillot maillot=maillotConverter.model2entity(maillotModel);
		return maillotJpaRepository.save(maillot);
	}

 
	@Override
	public Maillot updateMaillot(MaillotModel maillotModel) {
		Maillot maillot=maillotConverter.model2entity(maillotModel);
		return maillotJpaRepository.save(maillot);
	}

	@Override
	public int removeMaillot(String codigo) {
		maillotJpaRepository.deleteById(codigo);
		return 0;
	}
}
