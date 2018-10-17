
package com.citasmedicas.app.web.models.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citasmedicas.app.web.models.dao.IPacienteDAO;

import com.citasmedicas.app.web.models.entity.Paciente;
@Service
public class PacienteService  implements IPacienteService {
	@Autowired
	private IPacienteDAO dao;

	@Override
	@Transactional(readOnly=true)
	public List<Paciente> findAll() {
		List<Paciente> pacientes=(List<Paciente>) dao.findAll();
		return pacientes;
	}

	@Override
	@Transactional
	public void savePaciente(Paciente paciente) {
		dao.save(paciente);
	}

	@Override
	@Transactional(readOnly=true)
	public Paciente findById(Integer id) {
		Optional<Paciente> paciente=dao.findById(id);
		return paciente.get();
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
	

	

}
