package org.apci.aplicaciones.inscripcion.resources;

import javax.ws.rs.Path;

import org.apci.aplicaciones.inscripcion.dao.InscripcionDAO;
import org.apci.aplicaciones.inscripcion.services.IInscripcionService;

@Path ("/inscripcion")
public class InscripcionResource {
	IInscripcionService inscripcion;
	
	public InscripcionResource() {
		
		inscripcion = new InscripcionDAO();
	}
}
