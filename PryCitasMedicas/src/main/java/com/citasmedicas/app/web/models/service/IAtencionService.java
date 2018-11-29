package com.citasmedicas.app.web.models.service;

import java.util.Date;
import java.util.List;

import com.citasmedicas.app.web.models.entity.Atencion;

public interface IAtencionService {
	public List<Atencion> findAll();
	public void saveAtencion(Atencion atencion);
	public Atencion findById(Integer id);
	public void delete(Integer id);
	public List<Atencion> findByFecha(Date inicio, Date fin, Integer id);

}
