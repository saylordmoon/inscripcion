package org.apci.aplicaciones.inscripcion.dao;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Inscripcion;
import org.apci.aplicaciones.inscripcion.services.IInscripcionService;

public class InscripcionDAO extends BaseDAO implements IInscripcionService {
	@Override
	public Inscripcion add(Inscripcion pInscripcion) {
		
		int inscripcionId = insert(pInscripcion);
		
		pInscripcion.setInscripcionId(inscripcionId);
		
		return pInscripcion;
	}
}
