package br.edu.utfpr.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Person {

	private String username;
	private String password;
	private String email;
	private String passwordForgotHash;
	private long balance;

	public User() {
	}

	public User(String name, String username, String password, String role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordForgotHash() {
		return passwordForgotHash;
	}

	public void setPasswordForgotHash(String passwordForgotHash) {
		this.passwordForgotHash = passwordForgotHash;
	}

	public boolean isValid() {
		return !getName().equals("") && !getUsername().equals("") && !getPassword().equals("");
	}
}
