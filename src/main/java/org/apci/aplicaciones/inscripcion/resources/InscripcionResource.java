package org.apci.aplicaciones.inscripcion.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.dao.InscripcionDAO;
import org.apci.aplicaciones.inscripcion.models.Inscripcion;
import org.apci.aplicaciones.inscripcion.services.IInscripcionService;

@Path ("/inscripcion")
public class InscripcionResource {
	IInscripcionService inscripcion;
	
	public InscripcionResource() {
		
		inscripcion = new InscripcionDAO();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Inscripcion add(JAXBElement<Inscripcion> pInscripcion){
		
		return inscripcion.add(pInscripcion.getValue());
	}
	
}