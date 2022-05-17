package fr.formation.bll;

import java.util.List;

import fr.formation.bean.Bouquet;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.GenericDao;
import fr.formation.exception.BeanException;

public class BouquetManager {

	GenericDao<Bouquet, Integer> daoGen;
	
	public BouquetManager() {
		daoGen = DaoFactory.getGenericDAO();
	}
	
	public List<Bouquet> listBouquet(){
		return daoGen.findAllProduit(Bouquet.class);
	}
	

	public void ajoutBouquet(Bouquet b) throws Exception {
		if (b.getName() != null && !b.getName().trim().equals(""))
			daoGen.add(b);
		else
			throw new BeanException("La saison doit posséder un nom");
		
	}


	public void supprimerBouquet(int id) throws Exception {
		daoGen.deleteById(Bouquet.class, id);

	}


	public void modifierBouquet(Bouquet b) throws Exception {
		if (b.getName() != null && !b.getName().trim().equals(""))
			daoGen.update(b);
		else
			throw new BeanException("La saison doit posséder un nom");
	}


	public Bouquet trouverBouquet(int id) {
		return daoGen.findById(Bouquet.class, id);
	}

}
