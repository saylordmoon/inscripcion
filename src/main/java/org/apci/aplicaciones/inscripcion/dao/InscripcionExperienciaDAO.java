package org.apci.aplicaciones.inscripcion.dao;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionExperiencia;
import org.apci.aplicaciones.inscripcion.services.IInscripcionExperienciaService;

public class InscripcionExperienciaDAO extends BaseDAO implements IInscripcionExperienciaService {

	@Override
	public InscripcionExperiencia add(InscripcionExperiencia pExperiencia) {
		
		int experienciaId = insert(pExperiencia);
		
		pExperiencia.setInscripcionExperienciaId(experienciaId);
		
		return pExperiencia;
	}
}
