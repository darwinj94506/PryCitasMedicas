package com.citasmedicas.app.web.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.citasmedicas.app.web.models.dao.IEspecialidadDAO;

import com.citasmedicas.app.web.models.entity.Especialidad;

public class EspecialidadService implements IEspecialidadService {
	@Autowired
	private IEspecialidadDAO dao;

	@Override
	@Transactional(readOnly=true)
	public List<Especialidad> findAll() {
		List<Especialidad> especialidades=(List<Especialidad>) dao.findAll();
		return especialidades;
	}

	@Override
	@Transactional
	public void saveEspecialidad(Especialidad especialidad) {
		dao.save(especialidad);
	}

	@Override
	@Transactional(readOnly=true)
	public Especialidad findById(Integer id) {
		Optional<Especialidad> especialidad=dao.findById(id);
		return especialidad.get();
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
	

	

}
