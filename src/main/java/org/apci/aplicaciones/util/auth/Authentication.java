package org.apci.aplicaciones.util.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.WebApplicationException;

import org.apci.aplicaciones.inscripcion.models.Usuario;
import org.apci.aplicaciones.util.HttpUtil;

public class Authentication {
	
	public static final String SESSION_NAME = "5df9f63916ebf8528697b629022993e8";
	public static final String LOGIN_URL = "/login";
	public static final String LOGOUT_URL = "/";
	public static final String LOGIN_PAGE = "admin/index.html";
	public static final String LOGGED_PAGE = "app/";
	private static Usuario usuario;
	
	public static boolean isLoggedIn(HttpServletRequest pRequest)
	{
		HttpSession session = pRequest.getSession();

		return  (session.getAttribute(SESSION_NAME) != null && session.isNew() && session != null);
	}
	
	public static Usuario getUser(HttpServletRequest pRequest)
	{
		HttpSession session = pRequest.getSession(true);
		usuario = (Usuario)session.getAttribute(SESSION_NAME);
		if (usuario == null ) {
			throw new WebApplicationException(HttpUtil.StatusCode.UNAUTHORIZED.value());
		}
		
		return usuario;
	}
}
