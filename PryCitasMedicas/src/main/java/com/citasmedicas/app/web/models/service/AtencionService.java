package com.citasmedicas.app.web.models.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citasmedicas.app.web.models.dao.IAtencionDAO;
import com.citasmedicas.app.web.models.entity.Atencion;

@Service 
public class AtencionService implements IAtencionService {
	@Autowired
	private IAtencionDAO dao;

	@Override
	@Transactional(readOnly=true)
	public List<Atencion> findAll() {
		List<Atencion> atencion=(List<Atencion>) dao.findAll();
		return atencion;
	}

	@Override
	@Transactional
	public void saveAtencion(Atencion atencion) {
		dao.save(atencion);
	}

	@Override
	@Transactional(readOnly=true)
	public Atencion findById(Integer id) {
		Optional<Atencion> atencion=dao.findById(id);
		return atencion.get();
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
	
	@Override
	//@Transactional(readOnly=true)
	public List<Atencion> findByFecha(Date inicio, Date fin, Integer id){
		List<Atencion> atenciones=this.findAll();
		List<Atencion> resultado=new ArrayList<Atencion>();
		for(Atencion a: atenciones) {
			if(a.getFecha().after(inicio) && a.getFecha().before(fin)) {
				if(a.getMedico().getIdmedico()==id) {
					resultado.add(a);
				}
			}
		}
		return resultado;
	}

}
