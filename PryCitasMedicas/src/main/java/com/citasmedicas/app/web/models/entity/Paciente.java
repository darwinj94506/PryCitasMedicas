package com.citasmedicas.app.web.models.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "PACIENTE")

public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPACIENTE")
    private Integer idpaciente;
    @Size(max = 15)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 55)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "FECHANACIMIENTO")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Size(max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 15)
    @Column(name = "EMAIL")
    private String email;
 
    @OneToMany(mappedBy="paciente",fetch=FetchType.LAZY)
    private List<Atencion> atenciones;
    
   

    public Paciente() {
    }

    public Paciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

	public List<Atencion> getAtenciones() {
		return atenciones;
	}
	

    
}
    