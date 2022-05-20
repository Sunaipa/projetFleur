package fr.formation.bll;


import fr.formation.bean.Utilisateur;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.GenericDao;

public class ConnectionManager {

	GenericDao<Utilisateur, String> daoGen;
	
	public ConnectionManager() {
		daoGen = DaoFactory.getGenericDAO();
	}
	
	public Utilisateur trouverUser(String name) {
		
		return daoGen.findById(Utilisateur.class, name);
	}
}
