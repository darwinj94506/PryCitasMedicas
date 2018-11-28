package com.citasmedicas.app.web.models.service;

import java.util.List;

import com.citasmedicas.app.web.models.entity.Atencion;

public interface IAtencionService {
	public List<Atencion> findAll();
	public void saveAtencion(Atencion atencion);
	public Atencion findById(Integer id);
	public void delete(Integer id);

}
