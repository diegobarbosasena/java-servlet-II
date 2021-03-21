package br.com.diego.manager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.diego.manager.controller.ActionController;

//mapping in WebContent/WEB-INF/web.xml
public class ControllerFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("--> ControllerFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

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
