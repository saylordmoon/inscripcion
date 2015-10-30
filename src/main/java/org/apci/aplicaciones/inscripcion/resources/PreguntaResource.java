package org.apci.aplicaciones.inscripcion.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.dao.InstitucionDAO;
import org.apci.aplicaciones.inscripcion.dao.PreguntaDAO;
import org.apci.aplicaciones.inscripcion.dao.RespuestaDAO;
import org.apci.aplicaciones.inscripcion.models.Pregunta;
import org.apci.aplicaciones.inscripcion.models.Respuesta;
import org.apci.aplicaciones.inscripcion.services.IInstitucionService;
import org.apci.aplicaciones.inscripcion.services.IPreguntaService;
import org.apci.aplicaciones.inscripcion.services.IRespuestaService;

@Path("/pregunta")
public class PreguntaResource {
	IPreguntaService pregunta;
	IRespuestaService respuesta;
	IInstitucionService institucion;
	
	
	public PreguntaResource() {
		pregunta = new PreguntaDAO();
		respuesta = new RespuestaDAO();
		institucion = new InstitucionDAO();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Respuesta> get()
	{
		return respuesta.get();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/publicada")
	public List<Pregunta> publicadas()
	{
		return pregunta.publicadas();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Pregunta add(JAXBElement<Pregunta> pPregunta)
	{
		return pregunta.add(pPregunta.getValue());
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JAXBElement<Pregunta> pPregunta)
	{
		
		pregunta.update(pPregunta.getValue());
	
		return Response.status(Response.Status.OK).build();
	}
}
