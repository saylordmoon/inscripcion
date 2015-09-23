package org.apci.aplicaciones.inscripcion.dao;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionInscripcion;
import org.apci.aplicaciones.inscripcion.services.IInscripcionInscripcionService;

public class InscripcionInscripcionDAO extends BaseDAO implements IInscripcionInscripcionService {
	@Override
	public InscripcionInscripcion add(InscripcionInscripcion pInscripcion) {
		
		int inscripcionId = insert(pInscripcion);
		
		pInscripcion.setInscripcionId(inscripcionId);
		
		return pInscripcion;
	}

}
