package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionTematica;
import org.apci.aplicaciones.inscripcion.services.IInscripcionTematicaService;

public class InscripcionTematicaDAO extends BaseDAO implements IInscripcionTematicaService {

	@Override
	public List<InscripcionTematica> get() {
		
		return super.select(InscripcionTematica.class);
	}
}
