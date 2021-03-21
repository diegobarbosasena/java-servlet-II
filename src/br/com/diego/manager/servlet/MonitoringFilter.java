package br.com.diego.manager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//mapping in WebContent/WEB-INF/web.xml
public class MonitoringFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("--> MonitoringFilter");

		long before = System.currentTimeMillis();

		String controller = request.getParameter("controller");

		chain.doFilter(request, response);

		long after = System.currentTimeMillis();

		System.out.println("Runtime Controller: " + controller + " -> " + (after - before));
	}
}
