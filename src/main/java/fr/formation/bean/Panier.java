package fr.formation.bean;

import java.util.List;

public class Panier {
	
	private List<PanierLigne> panier;
	
	public Panier() {
		
	}
	public Panier(List<PanierLigne> panier) {
		this.panier = panier;
	}
	
	
	
	public List<PanierLigne> getPanier() {
		return panier;
	}
	public void setPanier(List<PanierLigne> panier) {
		this.panier = panier;
	}
	
}
