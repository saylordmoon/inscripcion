package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InscripcionTematica {
	
	private int InscripcionTematicaId;
	private String Descripcion;
	
	public int getInscripcionTematicaId() {
		return InscripcionTematicaId;
	}
	public void setInscripcionTematicaId(int inscripcionTematicaId) {
		InscripcionTematicaId = inscripcionTematicaId;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}
