package org.apci.aplicaciones.inscripcion.resources;

import java.util.List;

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
	@Produces(MediaType.APPLICATION_JSON)
	public List<InscripcionTematica> get()
	{
		return tematica.get();
	}
	
	
}