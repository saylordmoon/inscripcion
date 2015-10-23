package org.apci.aplicaciones.inscripcion.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.apci.aplicaciones.inscripcion.models.Usuario;
import org.apci.aplicaciones.util.auth.Authentication;
import org.apci.aplicaciones.util.auth.AuthenticationAdmin;


@Path("/usuario")
public class UsuarioResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/admin")
	public Response getAdmin(@Context HttpServletRequest pRequest)
	{
		AuthenticationAdmin.getUser(pRequest);
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@Context HttpServletRequest pRequest)
	{
		Authentication.getUser(pRequest);
		return Response.status(Response.Status.OK).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Usuario login(JAXBElement<Usuario> pUsuario , @Context HttpServletRequest pRequest)
	{
		HttpSession session = pRequest.getSession();
		session.setAttribute(Authentication.SESSION_NAME,pUsuario.getValue());
		
		return pUsuario.getValue();
	}
	
	//agregado
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/loginconsulta")
	public Usuario loginconsulta(JAXBElement<Usuario> pUsuario , @Context HttpServletRequest pRequest)
	{
		HttpSession session = pRequest.getSession();
		session.setAttribute(Authentication.SESSION_NAME,pUsuario.getValue());
		
		return pUsuario.getValue();
	}
}
