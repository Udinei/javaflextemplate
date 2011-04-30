package com.myorg.business.repositorys;


import org.springframework.stereotype.Repository;

import com.myorg.business.entitys.Entidade;
import com.myorg.infrastructure.GenericDAOImpl;

  

@Repository
public class EntidadeDAOImpl extends GenericDAOImpl<Entidade> implements EntidadeDAO {

	public EntidadeDAOImpl() {
		super(Entidade.class);
		System.out.println("Entidade DAO++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	
	
	
	 
} 