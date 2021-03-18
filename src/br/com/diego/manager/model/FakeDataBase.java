package br.com.diego.manager.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FakeDataBase {

	private static List<Company> companies = new ArrayList<>();
	private static Integer sequentialKey = 1;

	static {
		Company company = new Company();
		company.setName("Natural");
		company.setId(sequentialKey++);

		Company company2 = new Company();
		company2.setName("Harmonia");
		company2.setId(sequentialKey++);

		companies.add(company);
		companies.add(company2);
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
}
