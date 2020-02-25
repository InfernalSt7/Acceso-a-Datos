package com.ciclismo1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ciclismo1.converter.EquipoConverter;
import com.ciclismo1.entity.Equipo;
import com.ciclismo1.model.EquipoModel;
import com.ciclismo1.repository.EquipoJpaRepository;
import com.ciclismo1.service.EquipoService;

@Service("equipoServiceImpl")
public class EquipoServiceImpl implements EquipoService {
	
	@Autowired
	@Qualifier("equipoJpaRepository")
	private EquipoJpaRepository equipoJpaRepository;
	
	@Autowired
	@Qualifier("equipoConverter")
	private EquipoConverter equipoConverter;
	
	@Override
	public List<EquipoModel> listAllEquipos() {
		List<EquipoModel> equipoModel=new ArrayList<EquipoModel>();
		for(Equipo equipo: equipoJpaRepository.findAll())
			equipoModel.add(equipoConverter.entity2model(equipo));
		return equipoModel;
	}

	@Override
	public Equipo addEquipo(EquipoModel equipoModel) {
		Equipo equipo=equipoConverter.model2entity(equipoModel);
		return equipoJpaRepository.save(equipo);
	}

 
	@Override
	public Equipo updateEquipo(EquipoModel equipoModel) {
		Equipo equipo=equipoConverter.model2entity(equipoModel);
		return equipoJpaRepository.save(equipo);
	}

	@Override
	public int removeEquipo(String nomeq) {
		equipoJpaRepository.deleteById(nomeq);
		return 0;
	}
}
