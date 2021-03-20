package br.com.diego.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.diego.manager.model.FakeDataBase;
import br.com.diego.manager.model.User;

public class Login implements ActionController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginParam = request.getParameter("login");
		String passParam = request.getParameter("pass");

		System.out.println("Login " + loginParam);

		FakeDataBase fakeDataBase = new FakeDataBase();
		User user = fakeDataBase.validUser(loginParam, passParam);

		boolean validUser = user != null;

		if (validUser)
			System.out.println("Valid User");

		return validUser ? "redirect:entry?controller=ListCompanies" : "redirect:entry?controller=Index";
	}
}
