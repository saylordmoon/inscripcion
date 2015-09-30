package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Departamento {
	
	private int DepartamentoId;
	private String Nombre;
	private String Codigo;
	private String svg;
	
	public int getDepartamentoId() {
		return DepartamentoId;
	}
	public void setDepartamentoId(int departamentoId) {
		DepartamentoId = departamentoId;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getSvg() {
		return svg;
	}
	public void setSvg(String svg) {
		this.svg = svg;
	}
	
	

}
