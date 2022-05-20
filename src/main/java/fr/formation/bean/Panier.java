package fr.formation.bean;

import java.util.ArrayList;
import java.util.List;

public class Panier {

	private List<PanierLigne> lignes;
	
	public Panier() {
		this.lignes = new ArrayList<PanierLigne>();
	}

	public List<PanierLigne> getLignes() {
		return lignes;
	}
	public void setLignes(List<PanierLigne> lignes) {
		this.lignes = lignes;
	}
	
}
