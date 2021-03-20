package br.com.diego.manager.model;

public class User {

	private String login;
	private String pass;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isEquals(String login, String pass) {
		if (!this.login.equals(login))
			return false;

		if (!this.pass.equals(pass))
			return false;

		return true;
	}
}
