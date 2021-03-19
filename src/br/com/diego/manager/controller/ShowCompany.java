package br.com.diego.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.diego.manager.model.Company;
import br.com.diego.manager.model.FakeDataBase;

public class ShowCompany implements ActionController {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Controller Show Company");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		FakeDataBase fakeDataBase = new FakeDataBase();

		Company company = fakeDataBase.findById(id);

		request.setAttribute("company", company);

		return "forward:form-edit-company.jsp";
	}
}
