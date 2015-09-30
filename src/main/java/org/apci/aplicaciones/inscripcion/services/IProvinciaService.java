package org.apci.aplicaciones.inscripcion.services;

import java.util.List;

import org.apci.aplicaciones.inscripcion.models.Distrito;
import org.apci.aplicaciones.inscripcion.models.Provincia;

public interface IProvinciaService {

	List<Provincia> get();
	
	List<Distrito> distritos(int pProvinciaId);
}
