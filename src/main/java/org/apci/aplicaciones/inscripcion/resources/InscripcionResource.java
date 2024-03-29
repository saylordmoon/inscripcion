package org.apci.aplicaciones.inscripcion.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.dao.InscripcionDAO;
import org.apci.aplicaciones.inscripcion.models.Inscripcion;
import org.apci.aplicaciones.inscripcion.models.InscripcionInstitucion;
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
	
	@GET
	@Path("/{ruc}/validar")
	public Response exists(@PathParam("ruc") String pRUC )
	{
		if (inscripcion.validate(pRUC))
			return Response.status(Response.Status.OK).build();
		
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<InscripcionInstitucion> get(@Context HttpServletRequest pRequest)
	{
		//Authentication.getUser(pRequest);
		return inscripcion.get();
	}
}