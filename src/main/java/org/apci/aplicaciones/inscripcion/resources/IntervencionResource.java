package org.apci.aplicaciones.inscripcion.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apci.aplicaciones.inscripcion.dao.IntervencionDAO;
import org.apci.aplicaciones.inscripcion.models.Intervencion;
import org.apci.aplicaciones.inscripcion.services.IIntervencionService;


@Path("/intervencion")
public class IntervencionResource {
	IIntervencionService intervencion;
	
	public IntervencionResource() {
		intervencion = new IntervencionDAO();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{InstitucionId}")
	public List<Intervencion> get(@PathParam("InstitucionId") int pInstitucion, @Context HttpServletRequest pRequest) {
		
		return  intervencion.get(pInstitucion);
	}

}
