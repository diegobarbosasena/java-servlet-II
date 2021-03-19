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

public class UpdateCompany implements ActionController {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String companyName = request.getParameter("companyName");
		String paramOpeningDate = request.getParameter("openingDate");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println("Controller Update Company " + id);

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

		return "redirect:entry?controller=ListCompanies";
	}
}
