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

@WebServlet("/update-company")
public class UpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Updating Company");

		request.setCharacterEncoding("UTF-8");

		String companyName = request.getParameter("companyName");
		String paramOpeningDate = request.getParameter("openingDate");
		String paramId = request.getParameter("id");

		Integer id = Integer.valueOf(paramId);

		Date openingDate = null;

		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = format.parse(paramOpeningDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		FakeDataBase fakeDataBase = new FakeDataBase();

		Company company = fakeDataBase.findById(id);
		company.setName(companyName);
		company.setOpeningDate(openingDate);

		response.sendRedirect("companies");
	}
}
