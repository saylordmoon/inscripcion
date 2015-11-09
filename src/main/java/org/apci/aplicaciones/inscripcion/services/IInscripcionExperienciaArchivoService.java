package org.apci.aplicaciones.inscripcion.services;

import java.util.List;

import org.apci.aplicaciones.inscripcion.models.InscripcionExperienciaArchivo;

public interface IInscripcionExperienciaArchivoService {
	
	InscripcionExperienciaArchivo add(InscripcionExperienciaArchivo pArchivo);
	
	List<InscripcionExperienciaArchivo> getAll(int pExperienciaId);
	
	InscripcionExperienciaArchivo remove(int pInscripcionExperienciaArchivoId);

}

