package org.apci.aplicaciones.inscripcion.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import org.apci.aplicaciones.util.auth.Authentication;


@Path("/usuario")
public class UsuarioResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@Context HttpServletRequest pRequest)
	{
		Authentication.getUser(pRequest);
		return Response.status(Response.Status.OK).build();
	}
}
