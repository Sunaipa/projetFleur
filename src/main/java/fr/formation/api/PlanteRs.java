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

import fr.formation.bean.Plante;
import fr.formation.bll.PlanteManager;

@Path("/plante")
@Singleton
public class PlanteRs {
	
	private PlanteManager planteManager;

	public PlanteRs() {
		planteManager = new PlanteManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plante> getPlante(){
		System.out.println("ici : Plante");
		return planteManager.listPlante();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Plante getPlante(@PathParam("id") int id) {
		try {
			Plante p = planteManager.trouverPlante(id);
			if (p != null)
				return p;
			else
				throw new WebApplicationException(Response.Status.CONFLICT);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postPlante(Plante p) {
		try {
			planteManager.ajoutPlante(p);
			System.out.println("Ajout de " + p);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@DELETE
	@Path("/{id}")
	public void removePlante(@PathParam("id") int id) {
		try {
			planteManager.supprimerPlante(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putPlante(Plante p, @PathParam("id") int id) {
		try {
			p.setId(id);
			planteManager.modifierPlante(p);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}
