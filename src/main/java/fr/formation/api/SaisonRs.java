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

import fr.formation.bean.Saison;
import fr.formation.bll.SaisonManager;

@Path("/saison")
@Singleton
public class SaisonRs {
	
	private SaisonManager saisonManager;
	
	public SaisonRs() {
		saisonManager = new SaisonManager();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Saison> getSaison(){
		System.out.println("ici : saison");
		return saisonManager.listSaison();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Saison getSaison(@PathParam("id") int id) {
		try {
			Saison s = saisonManager.trouverSaison(id);
			if (s != null)
				return s;
			else
				throw new WebApplicationException(Response.Status.CONFLICT);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postSaison(Saison s) {
		try {
			saisonManager.ajoutSaison(s);
			System.out.println("Ajout de " + s);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@DELETE
	@Path("/{id}")
	public void removeSaison(@PathParam("id") int id) {
		try {
			saisonManager.supprimerSaison(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putSaison(Saison s, @PathParam("id") int id) {
		try {
			s.setId(id);
			saisonManager.modifierSaison(s);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}
