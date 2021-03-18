package br.com.diego.manager.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/new-company")
public class NewCompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("creating a new company");

		request.setCharacterEncoding("UTF-8");
		String companyName = request.getParameter("companyName");
		String paramOpeningDate = request.getParameter("openingDate");

		Date openingDate = null;

		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = format.parse(paramOpeningDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Company company = new Company();
		company.setName(companyName);
		company.setOpeningDate(openingDate);

		FakeDataBase fakeDataBase = new FakeDataBase();
		fakeDataBase.save(company);

		request.setAttribute("company", company.getName());
		response.sendRedirect("companies");
	}
}
