package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Inscripcion;
import org.apci.aplicaciones.inscripcion.models.InscripcionInstitucion;
import org.apci.aplicaciones.inscripcion.services.IInscripcionService;

public class InscripcionDAO extends BaseDAO implements IInscripcionService {
	@Override
	public Inscripcion add(Inscripcion pInscripcion) {
		
		int inscripcionId = insert(pInscripcion);
		
		pInscripcion.setInscripcionId(inscripcionId);
		
		return pInscripcion;
	}

	@Override
	public boolean validate(String pRUC) {
		
		boolean result = false;
		
		List<Inscripcion> exists = selectWhere(Inscripcion.class,"Usuario",pRUC);
		
		result = (exists.size() == 0);
		
		return result;
	}

	@Override
	public List<InscripcionInstitucion> get() {

		return query("SELECT InscripcionId, NombreInstitucion, usuario as RUC FROM inscripcion",InscripcionInstitucion.class);
	}
}
