package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InscripcionExperiencia {
	private int InscripcionExperienciaId;
	private int InscripcionId;
	private String Titulo;
	private int TematicaId;
	private int IntervencionId;
	
	public int getInscripcionExperienciaId() {
		return InscripcionExperienciaId;
	}
	public void setInscripcionExperienciaId(int inscripcionExperienciaId) {
		InscripcionExperienciaId = inscripcionExperienciaId;
	}
	public int getInscripcionId() {
		return InscripcionId;
	}
	public void setInscripcionId(int inscripcionId) {
		InscripcionId = inscripcionId;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public int getTematicaId() {
		return TematicaId;
	}
	public void setTematicaId(int tematicaId) {
		TematicaId = tematicaId;
	}
	public int getIntervencionId() {
		return IntervencionId;
	}
	public void setIntervencionId(int intervencionId) {
		IntervencionId = intervencionId;
	}

}
