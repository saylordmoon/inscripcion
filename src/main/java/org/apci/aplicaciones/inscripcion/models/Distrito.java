package org.apci.aplicaciones.inscripcion.models;

public class Distrito {
	
	private int DistritoId;
	private int ProvinciaId;
	private String Nombre;
	private String Codigo;
	private String svg;
	
	public int getDistritoId() {
		return DistritoId;
	}
	public void setDistritoId(int distritoId) {
		DistritoId = distritoId;
	}
	public int getProvinciaId() {
		return ProvinciaId;
	}
	public void setProvinciaId(int provinciaId) {
		ProvinciaId = provinciaId;
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
