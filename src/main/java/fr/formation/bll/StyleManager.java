package fr.formation.bll;

import java.util.List;

import fr.formation.bean.Style;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.GenericDao;
import fr.formation.exception.BeanException;

public class StyleManager {

	GenericDao<Style, Integer> daoGen;
	
	public StyleManager() {
		daoGen = DaoFactory.getGenericDAO();
	}
	
	
	public List<Style> listStyle(){
		return daoGen.findAll(Style.class);
	}
	

	public void ajoutStyle(Style s) throws Exception {
		if (s.getName() != null && !s.getName().trim().equals(""))
			daoGen.add(s);
		else
			throw new BeanException("La saison doit posséder un nom");
		
	}


	public void supprimerStyle(int id) throws Exception {
		daoGen.deleteById(Style.class, id);

	}


	public void modifierStyle(Style s) throws Exception {
		if (s.getName() != null && !s.getName().trim().equals(""))
			daoGen.update(s);
		else
			throw new BeanException("Le style doit posséder un nom");
	}


	public Style trouverStyle(int id) {
		return daoGen.findById(Style.class, id);
	}
}
