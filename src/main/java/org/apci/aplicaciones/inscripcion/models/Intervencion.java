package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Intervencion {

	private int IntervencionId;
	private String Nombre;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getIntervencionId() {
		return IntervencionId;
	}
	public void setIntervencionId(int intervencionId) {
		IntervencionId = intervencionId;
	}
}
