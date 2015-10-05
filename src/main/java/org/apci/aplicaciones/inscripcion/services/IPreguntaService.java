package org.apci.aplicaciones.inscripcion.services;

import java.util.List;

import org.apci.aplicaciones.inscripcion.models.Pregunta;

public interface IPreguntaService {

	List<Pregunta> get();
	
	List<Pregunta> publicadas();
 	
	Pregunta add(Pregunta pPregunta);
	
	boolean update(Pregunta pPregunta);
}
