package com.citasmedicas.app.web.models.service;
import com.citasmedicas.app.web.models.entity.Medico;
import java.util.List;

public interface IMedicoService {
	
	public List<Medico> findAll();
	public void saveMedico(Medico medico);
	public Medico findById(Integer id);
	public void delete(Integer id);
}
