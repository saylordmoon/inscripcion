package org.apci.aplicaciones.inscripcion.models;

public class Usuario {
	
	private int UnsuarioId;
	private String Usuario;
	private String Hash;
	
	public int getUnsuarioId() {
		return UnsuarioId;
	}
	public void setUnsuarioId(int unsuarioId) {
		UnsuarioId = unsuarioId;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getHash() {
		return Hash;
	}
	public void setHash(String hash) {
		Hash = hash;
	}
}
