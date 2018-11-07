package com.citasmedicas.app.web.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MEDICO")

public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICO")
    private Integer idmedico;
    @Size(max = 15)
    @Column(name = "CEDULA")
    @NotEmpty
    private String cedula;
    @Size(max = 55)
    @Column(name = "NOMBRE")
    @NotEmpty
    private String nombre;
    @Size(max = 15)
    @Column(name = "TELEFONO")
    @NotEmpty
    private String telefono;
    @Size(max = 5)
    @Column(name = "LICENCIA")
    @NotEmpty
    private String licencia;

    public Medico() {
    }

    public Medico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

}
