package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Distrito;
import org.apci.aplicaciones.inscripcion.models.Provincia;
import org.apci.aplicaciones.inscripcion.services.IProvinciaService;

public class ProvinciaDAO extends BaseDAO implements IProvinciaService{

	public List<Provincia> get() {
		return super.select(Provincia.class);
	}

	public List<Distrito> distritos(int pProvinciaId) {
		return super.execute("SpGetUbigeoProvinciaDistritos",Distrito.class, pProvinciaId);
	}

}
