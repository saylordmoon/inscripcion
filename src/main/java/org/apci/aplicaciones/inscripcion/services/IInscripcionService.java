package org.apci.aplicaciones.inscripcion.services;

import org.apci.aplicaciones.inscripcion.models.Inscripcion;

public interface IInscripcionService {
	
	Inscripcion add (Inscripcion pInscripcion);
	
	boolean validate(String pRUC);

}
