package org.apci.aplicaciones.inscripcion.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.dao.InscripcionExperienciaDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionExperiencia;
import org.apci.aplicaciones.inscripcion.models.Usuario;
import org.apci.aplicaciones.inscripcion.services.IInscripcionExperienciaService;
import org.apci.aplicaciones.util.auth.Authentication;


@Path("/experiencia")
public class InscripcionExperienciaResource {
	
	IInscripcionExperienciaService experiencia;
	
	public InscripcionExperienciaResource(){
		experiencia= new InscripcionExperienciaDAO();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<InscripcionExperiencia> get(@Context HttpServletRequest pRequest)
	{
		Usuario usuario = Authentication.getUser(pRequest);
		
		return experiencia.get(usuario.getUsuarioId());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public InscripcionExperiencia post (JAXBElement<InscripcionExperiencia> pExperiencia)
	{
		return experiencia.add(pExperiencia.getValue());
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JAXBElement<InscripcionExperiencia> pPregunta)
	{
				
		if (experiencia.update(pPregunta.getValue())){
			return Response.status(Response.Status.OK).build();
		}
		
		return Response.status(Response.Status.NOT_ACCEPTABLE).build();
	}
}
