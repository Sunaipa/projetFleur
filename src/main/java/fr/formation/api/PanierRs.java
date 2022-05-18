package fr.formation.api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.formation.bean.PanierLigne;
import fr.formation.bean.Produit;
import fr.formation.bll.ProduitManager;


@Path("/panier")
@Singleton
public class PanierRs {

private ProduitManager pM;
private List<PanierLigne> panier;
	
	public PanierRs() {
		this.panier = new ArrayList<PanierLigne>();
		this.pM = new ProduitManager();
	}
	
	@GET
	@Path("/nb")
	public int getPanierNb(){
		return this.panier.size();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PanierLigne> getPanier(){
		return this.panier;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postPanierLigne(PanierLigne pL) {
		Produit p = pM.trouverProduit(pL.getProduit().getId());
		pL.setProduit(p);
		this.panier.add(pL);
	}
	
	@DELETE
	@Path("/{id}")
	public void removeLignePanier(@PathParam("id") int id) {
		
		//A TEST !!!!!!!!!!!!!!!!!!!!!!!
	
	}
	
}
