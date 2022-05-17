package fr.formation.dal;



public class DaoFactory {

	public static <T, U> GenericDao<T, U> getGenericDAO(){
		return new GenericDaoImpl<T, U>();
	}
}
