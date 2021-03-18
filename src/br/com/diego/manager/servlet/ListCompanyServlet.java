package br.com.diego.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/companies")
public class ListCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FakeDataBase fakeDataBase = new FakeDataBase();

		List<Company> companies = fakeDataBase.getCompanies();

		request.setAttribute("companies", companies);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/companies.jsp");
		dispatcher.forward(request, response);
	}
}
