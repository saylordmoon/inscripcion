package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Institucion {
	private int institucionId;
	private String ruc;
	private String nombre;
	private String email;
	private String codigo;
	private String domicilio;
	private String telefono;

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getInstitucionId() {
		return institucionId;
	}
	public void setInstitucionId(int institucionId) {
		this.institucionId = institucionId;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
