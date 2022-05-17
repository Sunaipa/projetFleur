package fr.formation.bean;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Fleur extends Produit {
	
	private String color;
	@ManyToOne
	private Saison season;
	
	
	//CONTRUCTOR
	public Fleur() {
		super();
	}
	public Fleur(String color, Saison season) {
		super();
		this.color = color;
		this.season = season;
	}
	
	
	//GETTERS AND SETTERS
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Saison getSeason() {
		return season;
	}
	public void setSeason(Saison season) {
		this.season = season;
	}
	
	//OTHERS
	@Override
	public String toString() {
		return "Fleur [color=" + color + ", season=" + season + "]";
	}
}
