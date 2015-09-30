package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Departamento;
import org.apci.aplicaciones.inscripcion.models.Provincia;
import org.apci.aplicaciones.inscripcion.services.IDepartamentoService;

public class DepartamentoDAO extends BaseDAO implements IDepartamentoService {
	
	public List<Departamento> get() {
		return super.execute("SpGetUbigeoDepartamento", Departamento.class);
	}

	public List<Provincia> provincias(int pDepartamentoId) {
		return super.execute("SpGetUbigeoDepartamentoProvincias", Provincia.class, pDepartamentoId);
	}
}
