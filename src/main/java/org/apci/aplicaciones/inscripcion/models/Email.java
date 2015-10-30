package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Email {
	private String a;
	private String asunto;
	private String contenido;
	
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public String toJSON()
	{
		return String.format( "{\"a\":\"%s\",\"asunto\":\"%s\",\"contenido\":\"%s\"}", a,asunto,contenido);
	}
	
}
