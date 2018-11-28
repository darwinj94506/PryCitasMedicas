package com.citasmedicas.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.citasmedicas.app.web.models.entity.Atencion;


public interface IAtencionDAO extends CrudRepository<Atencion,Integer> {

}
