package org.apci.aplicaciones.inscripcion.models;

public class Usuario {
	
	private int UsuarioId;
	private String Usuario;
	private String Hash;
	
	public int getUsuarioId() {
		return UsuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		UsuarioId = usuarioId;
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
