package br.com.diego.manager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show-company")
public class ShowCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		FakeDataBase fakeDataBase = new FakeDataBase();

		Company company = fakeDataBase.findById(id);

		request.setAttribute("company", company);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/form-edit-company.jsp");
		dispatcher.forward(request, response);
	}
}
