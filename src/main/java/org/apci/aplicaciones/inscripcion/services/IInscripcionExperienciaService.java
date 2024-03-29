package org.apci.aplicaciones.inscripcion.services;

import java.util.List;

import org.apci.aplicaciones.inscripcion.models.InscripcionExperiencia;

public interface IInscripcionExperienciaService {
	
	InscripcionExperiencia add(InscripcionExperiencia pExperiencia);
	
	List<InscripcionExperiencia> get(int pInscripcion);
	
	List<InscripcionExperiencia> getAll();
	
	boolean update(InscripcionExperiencia pExperiencia);

}
