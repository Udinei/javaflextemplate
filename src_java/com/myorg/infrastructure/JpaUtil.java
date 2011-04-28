package com.myorg.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaUtil {
	
	private static EntityManagerFactory entityManagerFactory;
	private static ThreadLocal<EntityManager> entityThreadLocal;
	
	static {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("maindatabase");
		entityThreadLocal = new ThreadLocal<EntityManager>();   	
	}
	
	public static EntityManager getEntityManager(){
		
		EntityManager em = entityThreadLocal.get();  

		if(em == null){
	    	em = entityManagerFactory.createEntityManager();
	    	entityThreadLocal.set(em);
	    }
		
		return em;
	}
	
	
	public static void closeEntityManager(){
		EntityManager em = entityThreadLocal.get();  

		if(em != null){
	    	em.close();
	    	entityThreadLocal.set(null);
	    }
		
	}
}
