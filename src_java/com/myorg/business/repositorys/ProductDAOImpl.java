package com.myorg.business.repositorys;


import org.springframework.stereotype.Repository;

import com.myorg.business.entitys.Product;
import com.myorg.infrastructure.GenericDAOImpl;

  

@Repository
public class ProductDAOImpl extends GenericDAOImpl<Product> implements ProductDAO {

	public ProductDAOImpl() {
		super(Product.class);
		System.out.println("Product DAO++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	
	
	
	 
} 