package org.apci.aplicaciones.inscripcion.models;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Respuesta {
	
	private int PreguntaId;
	private String Texto;
	private String Respuesta;
	private int CategoriaId;
	private String QuienPregunta;
	private String QuienResponde;
	private int QPPersonaId;
	private int QPInstitucionId;
	private int QRPersonaId;
	private int QRInstitucionId;
	private String Departamento;
	private boolean Respondida;
	private boolean Publicada;
	private boolean Eliminada;
	private Timestamp FechaRegistro;
	public int getPreguntaId() {
		return PreguntaId;
	}
	public void setPreguntaId(int preguntaId) {
		PreguntaId = preguntaId;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
	public String getRespuesta() {
		return Respuesta;
	}
	public void setRespuesta(String respuesta) {
		Respuesta = respuesta;
	}
	public int getCategoriaId() {
		return CategoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		CategoriaId = categoriaId;
	}
	public String getQuienPregunta() {
		return QuienPregunta;
	}
	public void setQuienPregunta(String quienPregunta) {
		QuienPregunta = quienPregunta;
	}
	public String getQuienResponde() {
		return QuienResponde;
	}
	public void setQuienResponde(String quienResponde) {
		QuienResponde = quienResponde;
	}
	public int getQPPersonaId() {
		return QPPersonaId;
	}
	public void setQPPersonaId(int qPPersonaId) {
		QPPersonaId = qPPersonaId;
	}
	public int getQPInstitucionId() {
		return QPInstitucionId;
	}
	public void setQPInstitucionId(int qPInstitucionId) {
		QPInstitucionId = qPInstitucionId;
	}
	public int getQRPersonaId() {
		return QRPersonaId;
	}
	public void setQRPersonaId(int qRPersonaId) {
		QRPersonaId = qRPersonaId;
	}
	public int getQRInstitucionId() {
		return QRInstitucionId;
	}
	public void setQRInstitucionId(int qRInstitucionId) {
		QRInstitucionId = qRInstitucionId;
	}
	public String getDepartamento() {
		return Departamento;
	}
	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}
	public boolean isRespondida() {
		return Respondida;
	}
	public void setRespondida(boolean respondida) {
		Respondida = respondida;
	}
	public boolean isPublicada() {
		return Publicada;
	}
	public void setPublicada(boolean publicada) {
		Publicada = publicada;
	}
	public boolean isEliminada() {
		return Eliminada;
	}
	public void setEliminada(boolean eliminada) {
		Eliminada = eliminada;
	}
	public Timestamp getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Timestamp fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	
}
