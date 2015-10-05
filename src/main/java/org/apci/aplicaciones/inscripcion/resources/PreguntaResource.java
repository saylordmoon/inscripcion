package org.apci.aplicaciones.inscripcion.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.dao.PreguntaDAO;
import org.apci.aplicaciones.inscripcion.models.Pregunta;
import org.apci.aplicaciones.inscripcion.services.IPreguntaService;

@Path("/pregunta")
public class PreguntaResource {
	IPreguntaService pregunta;
	
	
	public PreguntaResource() {
		pregunta = new PreguntaDAO();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pregunta> get()
	{
		return pregunta.get();
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
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(JAXBElement<Pregunta> pPregunta)
	{
		String resp = "false";
		
		if (pregunta.update(pPregunta.getValue())){
			resp = "true";
		}
		
		return resp;
	}
}
