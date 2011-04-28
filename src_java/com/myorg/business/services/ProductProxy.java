package com.myorg.business.services;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.MethodProxy;

import org.springframework.stereotype.Component;

import com.myorg.business.entitys.Product;

/**
 * ProductProxy - Esta classe utiliza o padrão proxy para realizar tarefas de infraestrutura 
 * antes ou depois de algum evento realizada com um objeto na camada de view 
 * @author Udinei
 *
 */
@Component("productProxy")
public class ProductProxy implements ProductService, InvocationHandler
 {
	
   private Product product;
   
   private CadastrarProductSpecification spec = new CadastrarProductSpecification();
      
    public ProductProxy() {
  
     }
    
  


	public Object invoke(Object proxy, Method method, Object[] argumentos,
			MethodProxy methodProxy) throws Throwable {
		

		        try {
		            return method.invoke(product, argumentos);
		        } catch ( Exception e ) {
		            return new Integer(0);
		        }


		   //  Object retorno = method.invoke(productDAO, argumentos);
				     
		     //ex: 1
		     /*if(method.getName().startsWith("creditar")){
		    	 observavel.notificaEvento(argumentos[0]);
		      }*/
		  
		     //ex: 2
		    //Annotation  annotation = method.getAnnotation(EnviarEvento.class);
		     /*if(annotation != null){
		    	 observavel.notificaEvento(argumentos[0]);
		       }*/
		     //ex: 3
		     /*EnviarEvento annotation = method.getAnnotation(EnviarEvento.class);
		     
		   if(annotation != null && annotation.tipo().equals("teste")){
	    	 observavel.notificaEvento(argumentos[0]);
	       }*/
		     
		  /*   if(method.getName().startsWith("save")){
		    	 System.out.println("passou aqui");
		    	 //productDAO.insert((Product) proxy);
	      }*/
		
		//return retorno;
		  //   return null;
	}


    /**
     * Antes de salvar, verifica a se o objeto esta dentro da especificação esperada pela analise.
     */
	public Object save(Object obj) throws Exception {
	    
		Object retorno = null;
		
		try {
			  //Passa o objeto para verificar se esta na condição negocio especificada
			  if(this.spec.isSatisfiedBy((Product) obj)){ 
				retorno = obj;
			}else{
				retorno = null;
			}
			
		} catch (Exception e) {
		    
		} finally{ 
		    spec = null;
		}
		return obj;
	
	}

	
	public List<Object> findById(Object product) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			IllegalArgumentException, SecurityException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList getList(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Object> getSearch(Object product) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList listPaginacao(int firstResult, int maxResults)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Object proxyGeneric(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}


	public void remove(List<Object> product) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
	    return method.invoke(product, args);
		
	}

	

}
