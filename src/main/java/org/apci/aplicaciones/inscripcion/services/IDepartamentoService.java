package org.apci.aplicaciones.inscripcion.services;

import java.util.List;

import org.apci.aplicaciones.inscripcion.models.Departamento;
import org.apci.aplicaciones.inscripcion.models.Provincia;

public interface IDepartamentoService {
	
	List<Departamento> get();
	
	List<Provincia> provincias(int pDepartamentoId);
}
