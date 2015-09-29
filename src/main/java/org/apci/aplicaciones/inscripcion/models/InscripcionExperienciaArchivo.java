package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InscripcionExperienciaArchivo {
	private int InscripcionExperienciaArchivoId;
	private int InscripcionExperienciaId;
	private String Archivo;
	private String TipoArchivo;
	
	public int getInscripcionExperienciaArchivoId() {
		return InscripcionExperienciaArchivoId;
	}
	public void setInscripcionExperienciaArchivoId(int inscripcionExperienciaArchivoId) {
		InscripcionExperienciaArchivoId = inscripcionExperienciaArchivoId;
	}
	public int getInscripcionExperienciaId() {
		return InscripcionExperienciaId;
	}
	public void setInscripcionExperienciaId(int inscripcionExperienciaId) {
		InscripcionExperienciaId = inscripcionExperienciaId;
	}
	public String getArchivo() {
		return Archivo;
	}
	public void setArchivo(String archivo) {
		Archivo = archivo;
	}
	public String getTipoArchivo() {
		return TipoArchivo;
	}
	public void setTipoArchivo(String tipoArchivo) {
		TipoArchivo = tipoArchivo;
	}
}
