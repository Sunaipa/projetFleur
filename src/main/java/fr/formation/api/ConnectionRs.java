package fr.formation.api;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.formation.bean.Panier;
import fr.formation.bean.Utilisateur;
import fr.formation.bll.ConnectionManager;


@Path("/login")
@Singleton
public class ConnectionRs {
	
	@Context
	private HttpServletRequest httpRequest;
	
	private ConnectionManager connectionManager;

	public ConnectionRs() {
		connectionManager = new ConnectionManager();
	}
	
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur getUser(@PathParam("login") String name) {
		System.out.println("ici la");
		try {
			System.out.println("ici");
			Utilisateur u = connectionManager.trouverUser(name);
			if (u != null) {
				
				httpRequest.setAttribute("user", u);
				httpRequest.setAttribute("panier", new Panier());
				return u;
			}
			else
				throw new WebApplicationException(Response.Status.CONFLICT);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}