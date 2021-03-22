package br.com.diego.manager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// mapping in WebContent/WEB-INF/web.xml
public class AuthorizationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("--> AuthorizationFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramController = request.getParameter("controller");

		HttpSession session = request.getSession();
		boolean notLoggedUser = (session.getAttribute("loggedUser") == null);
		boolean isControllerProtected = !(paramController.equals("Login") || paramController.equals("Index"));

		if (isControllerProtected && notLoggedUser) {
			response.sendRedirect("entry?controller=Index");
			return;
		}

		chain.doFilter(request, response);
	}
}
