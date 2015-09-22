package org.apci.aplicaciones.inscripcion.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.dao.InscripcionExperienciaDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionExperiencia;
import org.apci.aplicaciones.inscripcion.services.IInscripcionExperienciaService;


@Path("/experiencia")
public class InscripcionExperienciaResource {
	
	IInscripcionExperienciaService experiencia;
	
	public InscripcionExperienciaResource(){
		experiencia= new InscripcionExperienciaDAO();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public InscripcionExperiencia post (JAXBElement<InscripcionExperiencia> pExperiencia)
	{
		return experiencia.add(pExperiencia.getValue());
	}
	
}
