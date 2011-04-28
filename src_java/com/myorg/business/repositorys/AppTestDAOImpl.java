package com.myorg.business.repositorys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.stereotype.Repository;

import com.myorg.business.entitys.AppTest;

@Repository(value = "AppTest")
public class AppTestDAOImpl implements AppTestDAO{
	
	
	@PersistenceContext
	EntityManager em;
	private int totalRegistros;
    
	
	public AppTest save(AppTest appTest) {
		if (appTest.getId() == 0) {
			appTest.setId(null);
		}

		if (appTest.getId() == null) {
			em.persist(appTest);

		} else {
			appTest = em.merge(appTest);

		}

		return appTest;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppTest> getList() {
		String jpql = "select p from AppTest as p";
		//seta o total de registro encontrados
		 return em.createQuery(jpql).setMaxResults(10).getResultList();
	}

	
	
	public void remove(AppTest produto) {
		em.remove(em.merge(produto));
	}

	@Override
	public AppTest findById(Integer id) {
		return em.find(AppTest.class, id);
	}

	@Override
	public AppTest findById(AppTest id) {
		return em.find(AppTest.class, id);
	}

	@Override
	public List<AppTest> getSearch(AppTest appTest) throws Exception {
		Session session = (Session) em.getDelegate();

		Criteria criteria = session.createCriteria(AppTest.class);

		Example example = Example.create(appTest).excludeZeroes().ignoreCase()
				.enableLike(MatchMode.ANYWHERE);

		criteria.add(example);
		return criteria.list();
	}

	@Override
	public ArrayList getList(int firstResult, int maxResults) {
		ArrayList arrayList = new ArrayList();
		
		String jpql = "select p from " + AppTest.class.getSimpleName()+ " as p";
		List result = em.createQuery(jpql).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
		List qtdRegistros  = em.createQuery(jpql).getResultList(); 
		
		
		arrayList.add(qtdRegistros.size());
		arrayList.add(result);
		
		return arrayList; 
	}

	@Override
	public List<AppTest> listPaginacao(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotalRegistros() throws Exception {
		String jpql = "select p from AppTest as p";
		totalRegistros = em.createQuery(jpql).getResultList().size();		
		return totalRegistros;
		
	}

	
}
		
		
	


	

