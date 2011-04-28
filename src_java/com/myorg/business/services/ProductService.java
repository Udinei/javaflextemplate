package com.myorg.business.services;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.myorg.infrastructure.GenericDAO;

public interface ProductService {


	public Object save(Object product) throws Exception;
	public void remove(List<Object> product)throws Exception;
	public List<Object> getSearch(Object product) throws Exception;
	public ArrayList listPaginacao(int firstResult, int maxResults) throws Exception;		
	public ArrayList getList(int firstResult, int maxResults) throws Exception;
	public List<Object> findById(Object product)	throws IllegalAccessException, InvocationTargetException,
	NoSuchMethodException, IllegalArgumentException, SecurityException, ClassNotFoundException;
	public Object proxyGeneric(Object obj);


}
