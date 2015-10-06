package org.apci.aplicaciones.inscripcion.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.apci.aplicaciones.inscripcion.dao.InstitucionDAO;
import org.apci.aplicaciones.inscripcion.models.Institucion;
import org.apci.aplicaciones.inscripcion.services.IInstitucionService;

@Path("/institucion")
public class InstitucionResource {
	IInstitucionService institucion;
	
	public InstitucionResource() {
		institucion = new  InstitucionDAO();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{ruc}")
	public Institucion get(@PathParam("ruc") String pRUC)
	{
		Institucion result = institucion.get(pRUC);
		
		if (result == null) {
			throw new WebApplicationException(404);
		}
		return result;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Institucion> getAll()
	{
		return institucion.getAll();
	}
}
