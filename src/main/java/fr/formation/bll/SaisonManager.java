package fr.formation.bll;

import java.util.List;

import fr.formation.bean.Saison;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.GenericDao;
import fr.formation.exception.BeanException;

public class SaisonManager {
	
	GenericDao<Saison, Integer> daoGen;
	
	public SaisonManager() {
		daoGen = DaoFactory.getGenericDAO();
	}
	
	
	public List<Saison> listSaison(){
		return daoGen.findAll(Saison.class);
	}


	public void ajoutSaison(Saison s) throws Exception {
		if (s.getName() != null && !s.getName().trim().equals(""))
			daoGen.add(s);
		else
			throw new BeanException("La saison doit posséder un nom");
		
	}


	public void supprimerSaison(int id) throws Exception {
		daoGen.deleteById(Saison.class, id);

	}


	public void modifierSaison(Saison s) throws Exception {
		if (s.getName() != null && !s.getName().trim().equals(""))
			daoGen.update(s);
		else
			throw new BeanException("La saison doit posséder un nom");
	}


	public Saison trouverSaison(int id) {
		return daoGen.findById(Saison.class, id);
	}
}
