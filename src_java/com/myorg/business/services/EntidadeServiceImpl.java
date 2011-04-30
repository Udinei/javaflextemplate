package com.myorg.business.services;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myorg.business.repositorys.EntidadeDAO;
import com.myorg.infrastructure.GenericDAO;
import com.myorg.infrastructure.ServiceSupport;


@Service(value = "entidadeServiceImpl")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EntidadeServiceImpl extends ServiceSupport implements EntidadeService{

	  
	private EntidadeDAO entidadeDAO; //injeta entidade
	private EntidadeProxy entidadeProxy; //injeta proxy
	 
	 
	@Autowired
	public void setEntidadeDAO(EntidadeDAO entidadeDAO) {
		this.entidadeDAO = entidadeDAO;
		this.genericDAO = (GenericDAO<Entity>) entidadeDAO;
		
	}

	
	@Resource(name="entidadeProxy")
	public void setEntidadeProxy(EntidadeProxy entidadeProxy) {
		this.entidadeProxy = entidadeProxy;
		this.proxyGeneric =  entidadeProxy;
		
	}



	
	
}
