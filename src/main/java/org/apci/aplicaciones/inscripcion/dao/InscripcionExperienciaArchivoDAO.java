package org.apci.aplicaciones.inscripcion.dao;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionExperienciaArchivo;
import org.apci.aplicaciones.inscripcion.services.IInscripcionExperienciaArchivoService;

public class InscripcionExperienciaArchivoDAO extends BaseDAO implements IInscripcionExperienciaArchivoService {

	@Override
	public InscripcionExperienciaArchivo add(InscripcionExperienciaArchivo pArchivo) {
		
		int inscripcionExperienciaArchivoId =  insert(pArchivo);
		
		pArchivo.setInscripcionExperienciaArchivoId(inscripcionExperienciaArchivoId);
		
		return pArchivo;
	}
}