package com.citasmedicas.app.web.models.service;
import com.citasmedicas.app.web.models.entity.Especialidad;
import java.util.List;

public interface IEspecialidadService{
	
	public List<Especialidad> findAll();
	
	public void saveEspecialidad(Especialidad especialidad);
	
	public Especialidad findById(Integer id);
	
	public void delete(Integer id);
}
