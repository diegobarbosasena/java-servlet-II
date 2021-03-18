package br.com.diego.manager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.diego.manager.model.Company;
import br.com.diego.manager.model.FakeDataBase;

public class ListCompanies {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Controller List Companies");

		FakeDataBase fakeDataBase = new FakeDataBase();

		List<Company> companies = fakeDataBase.getCompanies();

		request.setAttribute("companies", companies);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/companies.jsp");
		dispatcher.forward(request, response);
	}
}
