package org.apci.aplicaciones.inscripcion.models;

public class Usuario {
	
	private int UsuarioId;
	private String Usuario;
	private String Hash;
	private int InstitucionId;
	
	public int getInstitucionId() {
		return InstitucionId;
	}
	public void setInstitucionId(int institucionId) {
		InstitucionId = institucionId;
	}
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
