package fr.formation.api;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.formation.bean.Produit;
import fr.formation.bll.ProduitManager;

@Path("/produit")
@Singleton
public class ProduitRs {

private ProduitManager produitManager;
	
	public ProduitRs() {
		produitManager = new ProduitManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getProduit(){
		System.out.println("ici : Bouquet");
		return produitManager.listProduit();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit getproduit(@PathParam("id") int id) {
		try {
			Produit p = produitManager.trouverProduit(id);
			if (p != null)
				return p;
			else
				throw new WebApplicationException(Response.Status.CONFLICT);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

}
