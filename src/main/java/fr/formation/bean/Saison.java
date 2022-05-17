package fr.formation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Saison {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
	//CONSTRUCTOR
	public Saison() {
		super();
	}
	public Saison(String name) {
		this.name = name;
	}
	
	
	//GETTERS & SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	//OTHERS
	@Override
	public String toString() {
		return "Saison [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
