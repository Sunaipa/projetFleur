package fr.formation.bll;

import java.util.List;

import fr.formation.bean.Plante;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.GenericDao;
import fr.formation.exception.BeanException;

public class PlanteManager {
	
	GenericDao<Plante, Integer> daoGen;
	
	public PlanteManager() {
		daoGen = DaoFactory.getGenericDAO();
	}
	
	public List<Plante> listPlante(){
		return daoGen.findAllProduit(Plante.class);
	}


	public void ajoutPlante(Plante p) throws Exception {
		if (p.getName() != null && !p.getName().trim().equals(""))
			daoGen.add(p);
		else
			throw new BeanException("Les plante doivent posséder un nom");
		
	}


	public void supprimerPlante(int id) throws Exception {
		daoGen.deleteById(Plante.class, id);

	}


	public void modifierPlante(Plante p) throws Exception {
		if (p.getName() != null && !p.getName().trim().equals(""))
			daoGen.update(p);
		else
			throw new BeanException("Les plantes doivent posséder un nom");
	}


	public Plante trouverPlante(int id) {
		return daoGen.findById(Plante.class, id);
	}
}
