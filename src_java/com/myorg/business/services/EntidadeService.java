package com.myorg.business.services;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.myorg.infrastructure.GenericDAO;

public interface EntidadeService {


	public Object save(Object entidade) throws Exception;
	public void remove(List<Object> entidade)throws Exception;
	public List<Object> getSearch(Object v) throws Exception;
	public ArrayList listPaginacao(int firstResult, int maxResults) throws Exception;		
	public ArrayList getList(int firstResult, int maxResults) throws Exception;
	public List<Object> findById(Object entidade)	throws IllegalAccessException, InvocationTargetException,
	NoSuchMethodException, IllegalArgumentException, SecurityException, ClassNotFoundException;
	public Object proxyGeneric(Object obj);


}
