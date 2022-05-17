package fr.formation.bll;

import java.util.List;

import fr.formation.bean.Fleur;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.GenericDao;
import fr.formation.exception.BeanException;

public class FleurManager {

	GenericDao<Fleur, Integer> daoGen;
	
	public FleurManager() {
		daoGen = DaoFactory.getGenericDAO();
	}
	
	public List<Fleur> listFleur(){
		return daoGen.findAllProduit(Fleur.class);
	}
	

	public void ajoutFleur(Fleur f) throws Exception {
		if (f.getName() != null && !f.getName().trim().equals(""))
			daoGen.add(f);
		else
			throw new BeanException("La saison doit posséder un nom");
		
	}


	public void supprimerFleur(int id) throws Exception {
		daoGen.deleteById(Fleur.class, id);

	}


	public void modifierFleur(Fleur f) throws Exception {
		if (f.getName() != null && !f.getName().trim().equals(""))
			daoGen.update(f);
		else
			throw new BeanException("La saison doit posséder un nom");
	}


	public Fleur trouverFleur(int id) {
		return daoGen.findById(Fleur.class, id);
	}
	
}
