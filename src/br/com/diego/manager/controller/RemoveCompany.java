package br.com.diego.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.diego.manager.model.FakeDataBase;

public class RemoveCompany {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Controller Remove Company");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		FakeDataBase fakeDataBase = new FakeDataBase();
		fakeDataBase.delete(id);

		response.sendRedirect("entry?controller=companies");
	}
}
