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

import fr.formation.bean.Fleur;
import fr.formation.bll.FleurManager;

@Path("/fleur")
@Singleton
public class FleurRs {
	
	private FleurManager fleurManager;

	public FleurRs() {
		fleurManager = new FleurManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fleur> getFleur(){
		System.out.println("ici : Fleur");
		return fleurManager.listFleur();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Fleur getFleur(@PathParam("id") int id) {
		try {
			Fleur f = fleurManager.trouverFleur(id);
			if (f != null)
				return f;
			else
				throw new WebApplicationException(Response.Status.CONFLICT);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postFleur(Fleur f) {
		try {
			fleurManager.ajoutFleur(f);
			System.out.println("Ajout de " + f);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@DELETE
	@Path("/{id}")
	public void removeFleur(@PathParam("id") int id) {
		try {
			fleurManager.supprimerFleur(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putFleur(Fleur f, @PathParam("id") int id) {
		try {
			f.setId(id);
			fleurManager.modifierFleur(f);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}
