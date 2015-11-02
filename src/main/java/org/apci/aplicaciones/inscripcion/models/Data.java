package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data {
	
	private String texto;

	public String getText() {
		return texto;
	}

	public void setText(String text) {
		this.texto = text;
	}

}
