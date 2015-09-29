package org.apci.aplicaciones.inscripcion.models;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InscripcionExperiencia {
	private int InscripcionExperienciaId;
	private int InscripcionId;
	private String Titulo;
	private int TematicaId;
	private int IntervencionId;
	private String Sumilla;
	private String Ubigeo;
	private String Ambito;
	private Timestamp FechaInicio;
	private Timestamp FechaFin;
	private boolean Registrada;
	
	public String getSumilla() {
		return Sumilla;
	}
	public void setSumilla(String sumilla) {
		Sumilla = sumilla;
	}
	public String getUbigeo() {
		return Ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		Ubigeo = ubigeo;
	}
	public String getAmbito() {
		return Ambito;
	}
	public void setAmbito(String ambito) {
		Ambito = ambito;
	}
	public Timestamp getFechaInicio() {
		return FechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio) {
		FechaInicio = fechaInicio;
	}
	public Timestamp getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		FechaFin = fechaFin;
	}
	public boolean isRegistrada() {
		return Registrada;
	}
	public void setRegistrada(boolean registrada) {
		Registrada = registrada;
	}
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
