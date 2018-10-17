

package com.citasmedicas.app.web.models.dao;
import com.citasmedicas.app.web.models.entity.Especialidad;
import org.springframework.data.repository.CrudRepository;

public interface IEspecialidadDAO extends CrudRepository<Especialidad,Integer> {
	
}
