package com.myorg.infrastructure;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
* Essa classe prove os serviços basicos de CRUD e paginação para um objeto passado um manage bean.
* 
* @author Udinei
*
*/
 
@Repository
public abstract class GenericDAOImpl<Entity> implements GenericDAO<Entity> {
	
	@PersistenceContext
	private EntityManager _entityManager = null;
	private Class<Entity> _objectClass = null;
	private Integer id;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GenericDAOImpl(Class<Entity> objectClass) {
		_objectClass = objectClass;
		System.out.println("Generic DAO++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	


	@Transactional
	public void insert(Object entity) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, InstantiationException {
        
		    // Obtem a classe em processamento
		    Class<?> clazz = Class.forName(entity.getClass().getName());
		    
		    
		    // verifica se a classe tem o metodo getId()
			Method meth = clazz.getMethod("getId");
		    
			if (meth != null) {
			
				// invoca o metodo e retorna o valor do id
				Integer id = (Integer) meth.invoke(entity);
			
				// esta editando o objeto
				if (id != null && id != 0){
					_entityManager.merge(entity);
					
			  // esta incluindo o objeto
			  }else{
				   _entityManager.persist(entity);				  
			  }
		}
		
	}

	
	@Transactional
	public void remove(List<Object> listObj) throws Exception {
		try {
			
			for(Object obj: listObj){
			     _entityManager.remove(_entityManager.merge(obj));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Transactional
	public List<Object> getSearch(Object entity) throws Exception {
		Session session = (Session) _entityManager.getDelegate();
		//Class<?> clazz = Class.forName(entity.getClass().getName());
		//String classX = entity.getClass().getName();
		
		Criteria criteria = session.createCriteria(entity.getClass().getName().toString());

		Example example = Example.create(entity).excludeZeroes().ignoreCase()
				.enableLike(MatchMode.ANYWHERE);

		criteria.add(example);
		List list2 = criteria.list();
		List<Entity> list =  list2;
		return (List<Object>) list;
	}
	
	
	@Transactional
	public List<Object> getSearch(Object entity,  int firstResult , int maxResults) throws Exception {
		Session session = (Session) _entityManager.getDelegate();
		//Class<?> clazz = Class.forName(entity.getClass().getName());
		//String classX = entity.getClass().getName();
		
		Criteria criteria = session.createCriteria(entity.getClass().getName().toString()).setFirstResult(firstResult).setMaxResults(maxResults);
                    
		Example example = Example.create(entity).ignoreCase().enableLike(MatchMode.ANYWHERE);

		
		
		criteria.add(example);
		List list2 = criteria.list();
		List<Entity> list =  list2;
		return (List<Object>) list;
	}
	

	
	public Entity findById(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, ClassNotFoundException {
	Method meth = null;
	Integer id = null;
	//Class<Entity> entityRetorno = null;
	
	Class<?> clazz = Class.forName(obj.getClass().getName());
	
	
		meth = obj.getClass().getMethod("getId");
		
		Entity entityRetorno = null;
		if (meth != null) {
			
			// invoca o metodo e retorna o valor do id
			id = (Integer) meth.invoke(obj);
			
			
			if(id != null){
			    entityRetorno = _entityManager.find(_objectClass, id );
			}
		}
								
	return entityRetorno;
}

	
	public ArrayList getList(int firstResult, int maxResults) {
		ArrayList arrayList = new ArrayList();
		
		String jpql = "select obj from " + _objectClass.getSimpleName()+ " as obj order by obj.id asc";
		List result = _entityManager.createQuery(jpql).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
		List qtdRegistros  = _entityManager.createQuery(jpql).getResultList(); 
		
		
		arrayList.add(qtdRegistros.size());
		arrayList.add(result);
		
		return arrayList; 
	}


	public ArrayList getTotalRegistros(Object obj) {
		ArrayList arrayList = new ArrayList();
		if(obj != null ){
		   String objString = obj.getClass().getSimpleName();
		   String jpql = "select count(*) from " + objString.toString() + " as obj";
		   Long qtdRegistros  = (Long) _entityManager.createQuery(jpql).getSingleResult();
		   arrayList.add(qtdRegistros.toString());
		}
		return  arrayList;
	}
	
	
	
	public ArrayList<Entity> findAll() {
		Query query = _entityManager.createQuery("from "+ _objectClass.getName());
		return (ArrayList<Entity>) query.getResultList();
	}

		
	
	public EntityManager getEntityManager() {
		return _entityManager;
	}
	
	
	public void setEntityManager(EntityManager entityManager) {
		_entityManager = entityManager;
	}
}