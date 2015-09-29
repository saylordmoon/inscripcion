package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Institucion {
	private int institucionId;
	private String ruc;
	private String nombre;
	private int Departamento;
	private String Direccion;
	private int NumeroRegistro;
	private String Telefono;
	private String email;
	
		
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
	public int getDepartamento() {
		return Departamento;
	}
	public void setDepartamento(int departamento) {
		Departamento = departamento;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public int getNumeroRegistro() {
		return NumeroRegistro;
	}
	public void setNumeroRegistro(int numeroRegistro) {
		NumeroRegistro = numeroRegistro;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
