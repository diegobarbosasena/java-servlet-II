package br.com.diego.manager.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.diego.manager.model.Company;
import br.com.diego.manager.model.FakeDataBase;

public class NewCompany implements ActionController {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Save a New Company");

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

		return "redirect:entry?controller=ListCompanies";
	}
}
