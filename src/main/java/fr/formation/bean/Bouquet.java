package fr.formation.bean;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Bouquet extends Fleur {
	
	@ManyToOne
	private Style style;
	
	//CONSTRUCTOR
	public Bouquet() {
		super();
	}
	public Bouquet(Style style) {
		this.style = style;
	}
	
	
	//GETTERS & SETTERS
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	
	
	//OTHERS
	@Override
	public String toString() {
		return "Bouquet [style=" + style + "]";
	}
	
	
}
