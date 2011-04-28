package com.myorg.infrastructure;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.myorg.business.entitys.Product;
import com.myorg.business.repositorys.ProductDAO;
	  
	@Aspect  
	public class SalvarAspecto {   
	  
	@Around("execution(public * com.myorg.infrastructure.GenericDAO.insert(..))")   
	public void insert(ProceedingJoinPoint pjp) throws Throwable {   
	Product product = (Product) pjp.getThis();   
	ProductDAO productDAO = null;
	//productDAO.insert(product);
	System.out.println("teste aspecto");
	//productDAO.insert(product);   
	Object retVal = pjp.proceed();   
	//return retVal;   
	}   
  

}
