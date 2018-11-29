package com.citasmedicas.app.web.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ATENCION")
public class Atencion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDATENCION")
	private Integer idatencion;
	
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Size(max = 255)
    @Column(name = "OBSERVACION")
    @NotEmpty
    private String observacion;
    
    
    @Size(max = 2)
    @Column(name = "CELDA")
    @NotEmpty
    private String celda;
    
    @JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPACIENTE")
    @ManyToOne
    private Paciente paciente;
    
    @JoinColumn(name = "IDMEDICO", referencedColumnName = "IDMEDICO")
    @ManyToOne 
    private Medico medico;
    
    @JoinColumn(name = "IDESPECIALIDAD", referencedColumnName = "IDESPECIALIDAD")
    @ManyToOne
    private Especialidad especialidad;
    
    
   
    
    
    

	public String getCelda() {
		return celda;
	}



	public void setCelda(String celda) {
		this.celda = celda;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}



	public Medico getMedico() {
		return medico;
	}



	public void setMedico(Medico medico) {
		this.medico = medico;
	}



	public Especialidad getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}



	public Atencion(Integer idatencion) {
		super();
		this.idatencion = idatencion;
	}



	public Integer getIdatencion() {
		return idatencion;
	}



	public void setIdatencion(Integer idatencion) {
		this.idatencion = idatencion;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getObservacion() {
		return observacion;
		
	}



	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	



	
    
    

}
