package com.citasmedicas.app.web.models.dao;
import com.citasmedicas.app.web.models.entity.Medico;
import org.springframework.data.repository.CrudRepository;

public interface IMedicoDAO extends CrudRepository<Medico,Integer> {
	//con esta intefaz ya no utilizamos entitymanger

}
