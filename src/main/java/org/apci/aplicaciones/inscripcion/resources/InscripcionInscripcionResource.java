package org.apci.aplicaciones.inscripcion.resources;

import javax.ws.rs.Path;

import org.apci.aplicaciones.inscripcion.dao.InscripcionInscripcionDAO;
import org.apci.aplicaciones.inscripcion.services.IInscripcionInscripcionService;

@Path ("/inscripcion")
public class InscripcionInscripcionResource {
	IInscripcionInscripcionService inscripcion;
	
	public InscripcionInscripcionResource() {
		inscripcion = new InscripcionInscripcionDAO();
		
	}

}
