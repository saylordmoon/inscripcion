package org.apci.aplicaciones.inscripcion.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.dao.InscripcionTematicaDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionTematica;
import org.apci.aplicaciones.inscripcion.services.IInscripcionTematicaService;

@Path("/tematica")
public class InscripcionTematicaResource {
	
	IInscripcionTematicaService tematica;
	
	public InscripcionTematicaResource() {
		tematica = new InscripcionTematicaDAO();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_JSON)
	public String get()
	{
		return "functiona";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public InscripcionTematica post(JAXBElement<InscripcionTematica> pTematica)
	{
		return tematica.add(pTematica.getValue());
	}
	
	
	

}
