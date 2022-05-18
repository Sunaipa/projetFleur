package fr.formation.bean;

public class PanierLigne {
	
	private Produit produit;
	private int quantity;
	
	//CONSTRUCTOR
	public PanierLigne() {
		
	}
	public PanierLigne(Produit produit,int quantity) {
		this.produit = produit;
		this.quantity = quantity;
	}
	
	//GETTERS & SETTERS
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
