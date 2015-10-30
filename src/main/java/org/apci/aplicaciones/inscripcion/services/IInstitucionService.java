package org.apci.aplicaciones.inscripcion.services;

import java.util.List;
import org.apci.aplicaciones.inscripcion.models.Institucion;

public interface IInstitucionService {
	
	Institucion get (String pRUC);
	
	Institucion getById(int pInstitucionId);
	
	List<Institucion> getAll();
	
	
	
}
