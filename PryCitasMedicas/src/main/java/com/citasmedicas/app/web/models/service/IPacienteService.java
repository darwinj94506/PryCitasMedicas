
package com.citasmedicas.app.web.models.service;
import com.citasmedicas.app.web.models.entity.Paciente;
import java.util.List;

public interface IPacienteService {
	
	public List<Paciente> findAll();
	public void savePaciente(Paciente paciente);
	public Paciente findById(Integer id);
	public void delete(Integer id);
}
