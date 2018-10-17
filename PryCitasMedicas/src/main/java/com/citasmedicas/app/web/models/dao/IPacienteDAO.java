package com.citasmedicas.app.web.models.dao;
import com.citasmedicas.app.web.models.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface IPacienteDAO  extends CrudRepository<Paciente,Integer> {
	

}
