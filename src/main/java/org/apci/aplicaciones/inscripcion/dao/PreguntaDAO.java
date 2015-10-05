package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Pregunta;
import org.apci.aplicaciones.inscripcion.services.IPreguntaService;

public class PreguntaDAO extends BaseDAO implements IPreguntaService {

	@Override
	public List<Pregunta> get() {
		
		return super.select(Pregunta.class);
	}
	
	@Override
	public List<Pregunta> publicadas() {
		
		return super.selectWhere(Pregunta.class, "Publicada", true);
	}

	@Override
	public Pregunta add(Pregunta pPregunta) {
		
		int preguntaId  = super.insert(pPregunta);
		
		pPregunta.setPreguntaId(preguntaId);
		
		return pPregunta;
	}

	@Override
	public boolean update(Pregunta pPregunta) {
			
		return super.update(pPregunta);
		
	}
	
	

}
