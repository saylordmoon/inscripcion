package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Intervencion;
import org.apci.aplicaciones.inscripcion.services.IIntervencionService;

public class IntervencionDAO extends BaseDAO implements IIntervencionService {

	@Override
	public List<Intervencion> get(int pInstitucionId) {
		
		return query("SELECT DISTINCT nid_proyecto AS IntervencionId, proyecto AS Nombre FROM vi_experiencias WHERE nid_institucion = ?",Intervencion.class, pInstitucionId );
	}
}