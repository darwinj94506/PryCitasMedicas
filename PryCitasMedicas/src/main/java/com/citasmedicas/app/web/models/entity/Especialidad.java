package com.citasmedicas.app.web.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "ESPECIALIDAD")

public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESPECIALIDAD")
    private Integer idespecialidad;
    @Size(max = 55)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @OneToMany(mappedBy="especialidad",fetch=FetchType.LAZY)
    private List<Atencion> atenciones;
    
    
    public Especialidad() {
    }

    public Especialidad(Integer idespecialidad) {
    	super();
        this.idespecialidad = idespecialidad;
    }

    public Integer getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Atencion> getAtenciones() {
		return atenciones;
	}



    
}
