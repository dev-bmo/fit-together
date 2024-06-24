package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("url") != null) {
			request.getSession().setAttribute("redirectUrl", request.getParameter("url"));
		}else {
			request.getSession().setAttribute("redirectUrl", "/index");
		}
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
}
