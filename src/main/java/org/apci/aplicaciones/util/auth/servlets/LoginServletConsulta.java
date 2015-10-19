package org.apci.aplicaciones.util.auth.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apci.aplicaciones.util.auth.AuthenticationConsulta;
import org.apci.aplicaciones.inscripcion.dao.UsuarioDAO;
import org.apci.aplicaciones.inscripcion.models.Usuario;
import org.apci.aplicaciones.inscripcion.services.IUsuarioService;

@WebServlet("/loginconsulta")
public class LoginServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuarioService usuario;
	
	public LoginServletConsulta() {
     
		super();
		usuario = new UsuarioDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (AuthenticationConsulta.isLoggedIn(request)) {
			
			response.sendRedirect(AuthenticationConsulta.LOGGED_PAGE);
		}
		else {
			
			response.sendRedirect(AuthenticationConsulta.LOGIN_PAGE);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String username = request.getParameter("usuario").trim();
		String password = request.getParameter("password").trim();
		
		if (usuario.validate(username, password)) {
			
			HttpSession session = request.getSession();
			Usuario user = usuario.getByName(username);
			session.setAttribute(AuthenticationConsulta.SESSION_NAME,user);
			response.sendRedirect(AuthenticationConsulta.LOGGED_PAGE);
		}
		else {
			
			doGet(request, response);
		}
			
	}
}
