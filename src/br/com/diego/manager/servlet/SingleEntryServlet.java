package br.com.diego.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.diego.manager.controller.ListCompanies;
import br.com.diego.manager.controller.NewCompany;
import br.com.diego.manager.controller.RemoveCompany;
import br.com.diego.manager.controller.ShowCompany;
import br.com.diego.manager.controller.UpdateCompany;

@WebServlet("/entry")
public class SingleEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramController = request.getParameter("controller");

		if (paramController.equals("companies")) {
			ListCompanies controller = new ListCompanies();
			controller.execute(request, response);

		} else if (paramController.equals("removeCompany")) {
			RemoveCompany controller = new RemoveCompany();
			controller.execute(request, response);

		} else if (paramController.equals("showCompany")) {
			ShowCompany controller = new ShowCompany();
			controller.execute(request, response);

		} else if (paramController.equals("updateCompany")) {
			UpdateCompany controller = new UpdateCompany();
			controller.execute(request, response);
			
		} else if (paramController.equals("newCompany")) {
			NewCompany controller = new NewCompany();
			controller.execute(request, response);
		}
	}
}
