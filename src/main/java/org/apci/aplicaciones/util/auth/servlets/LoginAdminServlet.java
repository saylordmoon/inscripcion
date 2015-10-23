package org.apci.aplicaciones.util.auth.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apci.aplicaciones.util.auth.AuthenticationAdmin;
import org.apci.aplicaciones.inscripcion.dao.UsuarioDAO;
import org.apci.aplicaciones.inscripcion.models.Usuario;

@WebServlet("/loginadmin")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginAdminServlet() {
     
		super();
		new UsuarioDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (AuthenticationAdmin.isLoggedIn(request)) {
			
			response.sendRedirect(AuthenticationAdmin.LOGGED_PAGE);
		}
		else {
			
			response.sendRedirect(AuthenticationAdmin.LOGIN_PAGE);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String username = request.getParameter("usuario").trim();
		String password = request.getParameter("password").trim();
		
		if (username.equals("admin") && password.equals("admin123")) {
			
			HttpSession session = request.getSession();
			Usuario user = new  Usuario();
			user.setUsuario("Administrador");
			session.setAttribute(AuthenticationAdmin.SESSION_NAME,user);
			response.sendRedirect(AuthenticationAdmin.LOGGED_PAGE);
		}
		else {
			
			doGet(request, response);
		}
			
	}
}
