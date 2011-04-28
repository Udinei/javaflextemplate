package com.myorg.business.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.jmx.access.InvocationFailureException;

import com.myorg.infrastructure.GenericDAO;

/**
 * ServiceSupport - Classe generica que implementa metodos basicos, que trata as requisições recebidas da camada view
 * para persistencia, listagem ou paginação de uma entidade generica
 * @version  29 Mar 2011
 * @author Udinei Silva
 *
 */
public abstract class ServiceSupport  {

	/** instancia a da classe generica GenericDAO de persistencia */
	public GenericDAO<Entity> genericDAO;
	
	/** instancia do proxy generico para tratamento, de algumm evento */
	public Object proxyGeneric = null;
	
	
	//persiste um objeto
	public Object save(Object obj) throws Exception {


		try {
		
			if(proxyGeneric != null){
				
			
			Class<?> clazz = Class.forName(proxyGeneric.getClass().getName()); // Obtem a classe em processamento
			
			Class partypes[] = new Class[1]; //cria array de tipos	
				
            partypes[0] = Object.class; //seta e informa o tipo do parametro
            
         	Method meth = clazz.getMethod("save", partypes); // verifica se a classe tem o metodo save
			
			if (meth != null) {
		
				 Object arglist[] = new Object[1];  
	             arglist[0] = obj;
	    	
				// invoca o metodo save retorna o objeto ou null
				Object ob = meth.invoke(clazz.newInstance(), arglist);

			if (obj != null)
					genericDAO.insert(obj);
		    }
			}else{
				genericDAO.insert(obj);
			}

		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
		
		return obj;
		
		
	}
	
	
/**
 * listPaginação - Controla a paginação
 * @param firstResult
 * @param maxResults
 * @return Um arrayList de Objetos
 * @throws Exception
 */
	public ArrayList listPaginacao(int firstResult, int maxResults)
			throws Exception {

		try {
			return getList(firstResult, maxResults);
			
		} catch (Exception e) {
			throw new Exception("Não foi possivel listar " + e.getMessage());
		}
	}

	/**
	 * Lista os objetos apos salvar
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Entity> getList() throws Exception {
		try {

			ArrayList<Entity> listObj = genericDAO.findAll();
			/*
			 * for(Product prod: productList){
			 * System.out.println(prod.getName()); }
			 */

			return listObj;

		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
	}

	public ArrayList getList(int firstResult, int maxResults) throws Exception {
		try {

			ArrayList list = genericDAO.getList(firstResult, maxResults);

			return list;

		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
	}
	

    /**
     * remove um ou mais os objetos selecionados na grid
     */
	public void remove(List<Object> listObj) throws Exception {
		
		try {
					 
			this.genericDAO.remove(listObj);
			
		} catch (Exception e) {// TODO Auto-generated catch block
			throw new Exception("Não foi possível remover." );
		}
		
	}
	
	public List getSearch(Object obj, int firstResult, int maxResults) throws Exception {
		List listObj = null;
		
		try {
		
			// Obtem a classe em processamento
			Class<?> clazz = Class.forName(obj.getClass().getName());

			// verifica se a classe tem o metodo getId()
			Method meth = clazz.getMethod("getId");

			if (meth != null) {

				// invoca o metodo e retorna o valor do id
				Integer id = (Integer) meth.invoke(obj);

				if (id != 0){
					listObj = findById(obj);
				}else{
				    listObj = this.genericDAO.getSearch(obj, firstResult, maxResults);
				}

			}

		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
		
		return listObj;

	}
	
	public List getSearch(Object obj) throws Exception {
		List listObj = null;
		
		try {
		
			// Obtem a classe em processamento
			Class<?> clazz = Class.forName(obj.getClass().getName());

			// verifica se a classe tem o metodo getId()
			Method meth = clazz.getMethod("getId");

			if (meth != null) {

				// invoca o metodo e retorna o valor do id
				Integer id = (Integer) meth.invoke(obj);

				if (id != 0)
					listObj = findById(obj);
				    listObj = this.genericDAO.getSearch(obj);

			}

		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
		
		return listObj;

	}


	public List findById(Object obj) throws IllegalAccessException,
			InvocationFailureException, NoSuchMethodException,
			IllegalArgumentException, SecurityException, ClassNotFoundException, InvocationTargetException {
		List list = new ArrayList();
		Object objX =  this.genericDAO.findById(obj);
		list.add(objX);

		return list;
	}
	
	public List getTotalRegistros(Object obj){
		List list =  this.genericDAO.getTotalRegistros(obj);
		return list;
		 
	}
	
	
	public Object proxyGeneric(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

