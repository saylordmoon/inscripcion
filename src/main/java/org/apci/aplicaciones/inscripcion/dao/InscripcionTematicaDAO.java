package org.apci.aplicaciones.inscripcion.dao;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionTematica;
import org.apci.aplicaciones.inscripcion.services.IInscripcionTematicaService;

public class InscripcionTematicaDAO extends BaseDAO implements IInscripcionTematicaService {

	@Override
	public InscripcionTematica add(InscripcionTematica pTematica) {
		
		int tematicaId = insert(pTematica); 
		
		pTematica.setInscripcionTematicaId(tematicaId);
		
		return pTematica;
	}
}
