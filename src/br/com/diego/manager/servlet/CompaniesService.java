package br.com.diego.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.diego.manager.model.Company;
import br.com.diego.manager.model.FakeDataBase;

@WebServlet("/api/companies")
public class CompaniesService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Company> companies = new FakeDataBase().getCompanies();

		String header = request.getHeader("Accept");

		System.out.println("Header Value " + header);

		if (header.contains("xml")) {
			XStream xStream = new XStream();
			xStream.alias("company", Company.class);
			String xml = xStream.toXML(companies);

			response.setContentType("application/xml");
			response.getWriter().print(xml);

		} else if (header.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(companies);

			response.setContentType("application/json");
			response.getWriter().print(json);

		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'msg': 'no content'}");
		}
	}
}
