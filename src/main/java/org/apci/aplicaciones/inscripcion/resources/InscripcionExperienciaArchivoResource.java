package org.apci.aplicaciones.inscripcion.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.dao.InscripcionExperienciaArchivoDAO;
import org.apci.aplicaciones.inscripcion.models.InscripcionExperienciaArchivo;
import org.apci.aplicaciones.inscripcion.services.IInscripcionExperienciaArchivoService;

@Path("/archivoexperiencia")
public class InscripcionExperienciaArchivoResource {
	
	IInscripcionExperienciaArchivoService archivo;
	
	public InscripcionExperienciaArchivoResource() {
		archivo = new InscripcionExperienciaArchivoDAO();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{ExperienciaId}")
	public List<InscripcionExperienciaArchivo> get(@PathParam("ExperienciaId") int pExperienciaId) {
		
		return archivo.getAll(pExperienciaId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public InscripcionExperienciaArchivo add(JAXBElement<InscripcionExperienciaArchivo> pExperienciaArchivo){
	
		return archivo.add(pExperienciaArchivo.getValue());
	}
	

}