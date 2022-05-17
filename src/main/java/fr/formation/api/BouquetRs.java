package fr.formation.api;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.formation.bean.Bouquet;
import fr.formation.bll.BouquetManager;

@Path("/bouquet")
@Singleton
public class BouquetRs {

private BouquetManager bouquetManager;
	
	public BouquetRs() {
		bouquetManager = new BouquetManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bouquet> getBouquet(){
		System.out.println("ici : Bouquet");
		return bouquetManager.listBouquet();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bouquet getBouquet(@PathParam("id") int id) {
		try {
			Bouquet b = bouquetManager.trouverBouquet(id);
			if (b != null)
				return b;
			else
				throw new WebApplicationException(Response.Status.CONFLICT);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postBouquet(Bouquet b) {
		try {
			bouquetManager.ajoutBouquet(b);
			System.out.println("Ajout de " + b);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@DELETE
	@Path("/{id}")
	public void removeBouquet(@PathParam("id") int id) {
		try {
			bouquetManager.supprimerBouquet(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putBouquet(Bouquet b, @PathParam("id") int id) {
		try {
			b.setId(id);
			bouquetManager.modifierBouquet(b);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}
