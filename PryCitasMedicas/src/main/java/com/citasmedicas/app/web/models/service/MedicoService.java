package com.citasmedicas.app.web.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citasmedicas.app.web.models.dao.IMedicoDAO;
import com.citasmedicas.app.web.models.entity.Medico;
@Service 
public class MedicoService implements IMedicoService{
	@Autowired
	private IMedicoDAO dao;

	@Override
	@Transactional(readOnly=true)
	public List<Medico> findAll() {
		List<Medico> medicos=(List<Medico>) dao.findAll();
		return medicos;
	}

	@Override
	@Transactional
	public void saveMedico(Medico medico) {
		dao.save(medico);
	}

	@Override
	@Transactional(readOnly=true)
	public Medico findById(Integer id) {
		Optional<Medico> medico=dao.findById(id);
		return medico.get();
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

}
