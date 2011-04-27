package com.myorg.infrastructure;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

public interface GenericDAO<Entity> {

	@Transactional
	public abstract void insert(Object obj) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException,
			NoSuchMethodException, InstantiationException;


	public abstract ArrayList getList(int firstResult, int maxResults);

	public abstract ArrayList getTotalRegistros(Object obj);

	public abstract ArrayList<Entity> findAll();

	public abstract EntityManager getEntityManager();

	public abstract void setEntityManager(EntityManager entityManager);

	public Integer getId();

	public void setId(Integer id);
	
	@Transactional
	public abstract void remove(List<Object> obj) throws Exception;

	public abstract List<Object> getSearch(Object obj) throws Exception;


	public abstract Object findById(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, ClassNotFoundException;


	public abstract List getSearch(Object obj, int firstResult, int maxResults) throws Exception;

	
}