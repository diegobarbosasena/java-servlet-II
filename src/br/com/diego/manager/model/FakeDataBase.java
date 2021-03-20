package br.com.diego.manager.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FakeDataBase {

	private static List<Company> companies = new ArrayList<>();
	private static Integer sequentialKey = 1;

	private static List<User> users = new ArrayList<>();

	static {
		Company company = new Company();
		company.setName("Natural");
		company.setId(sequentialKey++);

		Company company2 = new Company();
		company2.setName("Harmonia");
		company2.setId(sequentialKey++);

		companies.add(company);
		companies.add(company2);

		User user = new User();
		user.setLogin("diego");
		user.setPass("pass");

		User user2 = new User();
		user2.setLogin("user");
		user2.setPass("pass");

		users.add(user);
		users.add(user2);
	}

	public void save(Company company) {
		company.setId(FakeDataBase.sequentialKey++);
		FakeDataBase.companies.add(company);
	}

	public List<Company> getCompanies() {
		return FakeDataBase.companies;
	}

	public void delete(Integer id) {
		Iterator<Company> iterator = companies.iterator();

		while (iterator.hasNext()) {
			Company company = iterator.next();

			if (company.getId().equals(id))
				iterator.remove();
		}
	}

	public Company findById(Integer id) {
		for (Company company : companies) {
			if (company.getId().equals(id))
				return company;
		}
		return null;
	}

	public User validUser(String login, String pass) {
		for (User user : users) {
			if (user.isEquals(login, pass))
				return user;
		}
		return null;
	}
}
