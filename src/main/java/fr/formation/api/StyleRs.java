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

import fr.formation.bean.Style;
import fr.formation.bll.StyleManager;

@Path("/style")
@Singleton
public class StyleRs {
		
	private StyleManager styleManager;
	
	public StyleRs() {
		styleManager = new StyleManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Style> getStyle(){
		System.out.println("ici : style");
		return styleManager.listStyle();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Style getStyle(@PathParam("id") int id) {
		try {
			Style s = styleManager.trouverStyle(id);
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
	public void postStyle(Style s) {
		try {
			styleManager.ajoutStyle(s);
			System.out.println("Ajout de " + s);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@DELETE
	@Path("/{id}")
	public void removeStyle(@PathParam("id") int id) {
		try {
			styleManager.supprimerStyle(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putStyle(Style s, @PathParam("id") int id) {
		try {
			s.setId(id);
			styleManager.modifierStyle(s);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}
