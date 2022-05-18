package fr.formation.bll;

import java.util.List;


import fr.formation.bean.Produit;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.GenericDao;

public class ProduitManager {

	GenericDao<Produit, Integer> daoGen;
	
	public ProduitManager() {
		daoGen = DaoFactory.getGenericDAO();
	}
	
	public List<Produit> listProduit(){
		return daoGen.findAllProduit(Produit.class);
	}

	public Produit trouverProduit(int id) {
		return daoGen.findById(Produit.class, id);
	}

}
