package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Respuesta;
import org.apci.aplicaciones.inscripcion.services.IRespuestaService;

public class RespuestaDAO extends BaseDAO implements IRespuestaService {

	@Override
	public List<Respuesta> get() {
		
		return super.query("select * from pregunta where categoriaId = 3", Respuesta.class);
	}

}
