package fr.formation.dal;

import java.util.List;

public interface GenericDao<T, U> {
	public void add(T t) throws Exception;

	public void delete(T t) throws Exception;

	public void update(T t) throws Exception;

	public void update(List<T> listeT) throws Exception;

	@SuppressWarnings("rawtypes")
	public T findById(Class c ,U id);

	@SuppressWarnings("rawtypes")
	public List<T> findAll(Class c);
	
	@SuppressWarnings("rawtypes")
	public List<T> findAllProduit(Class c);
	
	@SuppressWarnings("rawtypes")
	public void deleteById(Class c, int id);
		
}