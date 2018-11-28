package com.citasmedicas.app.web.filters;

import java.io.Serializable;

public class AtencionFilter implements Serializable{
	
	private static final long serialVErsionUID=1L;
	
	
	public AtencionFilter() {
		
	}
	
	public AtencionFilter(Integer idmedico, String inicio, String fin) {
		super();
		this.idmedico = idmedico;
		this.inicio = inicio;
		this.fin = fin;
	}
	private Integer idmedico;
	private String inicio;
	private String fin;
	public Integer getIdmedico() {
		return idmedico;
	}
	public void setIdmedico(Integer idmedico) {
		this.idmedico = idmedico;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	

}
