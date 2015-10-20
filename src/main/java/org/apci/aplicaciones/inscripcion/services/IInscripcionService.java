package org.apci.aplicaciones.inscripcion.services;

import java.util.List;

import org.apci.aplicaciones.inscripcion.models.Inscripcion;
import org.apci.aplicaciones.inscripcion.models.InscripcionInstitucion;

public interface IInscripcionService {
	
	Inscripcion add (Inscripcion pInscripcion);
	
	boolean validate(String pRUC);
	
	List<InscripcionInstitucion> get();

}
