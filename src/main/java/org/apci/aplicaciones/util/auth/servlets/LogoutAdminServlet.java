package org.apci.aplicaciones.util.auth.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apci.aplicaciones.util.auth.AuthenticationAdmin;

@WebServlet("/logoutadmin")
public class LogoutAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	public LogoutAdminServlet(){
		
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		if (session.getAttribute(AuthenticationAdmin.SESSION_NAME) != null || session.isNew() || session != null ){
			session.removeAttribute(AuthenticationAdmin.SESSION_NAME);
			session.invalidate();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(AuthenticationAdmin.LOGOUT_URL);
		rd.forward(request, response);
	}
}
