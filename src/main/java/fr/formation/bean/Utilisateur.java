package fr.formation.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	
	@Id
	private String name;
	private String password;

	public Utilisateur() {
	}

	public Utilisateur(String name, String password) {
		this.name = name;
		this.password = password;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

}
