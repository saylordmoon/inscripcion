package org.apci.aplicaciones.inscripcion.services;

import java.util.List;

import org.apci.aplicaciones.inscripcion.models.Intervencion;

public interface IIntervencionService {
	
	List<Intervencion> get(int pInstitucionId);

}
