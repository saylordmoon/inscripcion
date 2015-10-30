package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Institucion;
import org.apci.aplicaciones.inscripcion.services.IInstitucionService;

public class InstitucionDAO extends BaseDAO implements IInstitucionService{
	
	@Override
	public Institucion get(String pRUC) {	
		
		List<Institucion> institucion = super.query("SELECT * FROM VwExperiencias2015 WHERE ruc = ?", Institucion.class,pRUC);
		
		if (institucion.isEmpty()) {
			return null;
		}			
		return institucion.get(0);
		
	}

	@Override
	public List<Institucion> getAll() {		
		return query("select * from VwExperiencias2015",Institucion.class);
	}

	@Override
	public Institucion getById(int pInstitucionId) {
		
		return selectById(Institucion.class, pInstitucionId).get(0);
	}

}
