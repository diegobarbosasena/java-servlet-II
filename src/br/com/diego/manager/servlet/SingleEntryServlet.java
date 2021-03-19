package br.com.diego.manager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.diego.manager.controller.ActionController;

@WebServlet("/entry")
public class SingleEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramController = request.getParameter("controller");

		String className = "br.com.diego.manager.controller." + paramController;

		String viewName;
		try {
			Class classRef = Class.forName(className);
			ActionController actionController = (ActionController) classRef.newInstance();
			viewName = actionController.execute(request, response);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] viewAndController = viewName.split(":");

		if (viewAndController[0].equals("forward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/" + viewAndController[1]);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewAndController[1]);
		}
	}
}
