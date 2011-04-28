package com.myorg.business.services;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myorg.business.repositorys.ProductDAO;
import com.myorg.infrastructure.GenericDAO;


@Service(value = "productServiceImpl")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductServiceImpl extends ServiceSupport implements ProductService{

	  
	private ProductDAO productDAO; //injeta entidade
	private ProductProxy productProxy; //injeta proxy
	 
	 
	@Autowired
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
		this.genericDAO = (GenericDAO<Entity>) productDAO;
		
	}

	
	@Resource(name="productProxy")
	public void setProductProxy(ProductProxy productProxy) {
		this.productProxy = productProxy;
		this.proxyGeneric =  productProxy;
		
	}



	
	
}
