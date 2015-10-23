package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

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

	@Override
	public List<InscripcionExperiencia> get(int pInscripcionId) {

		return selectWhere(InscripcionExperiencia.class,"InscripcionId",pInscripcionId);
	}

	@Override
	public boolean update(InscripcionExperiencia pExperiencia) {
		
		return super.update(pExperiencia);
	}

	@Override
	public List<InscripcionExperiencia> getAll() {
		
		return super.query("Select * from inscripcionExperiencia where InscripcionExperienciaId > 65",InscripcionExperiencia.class);
	}
	
	
}
