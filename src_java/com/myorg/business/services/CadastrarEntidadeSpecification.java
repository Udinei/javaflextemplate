package com.myorg.business.services;

import org.springframework.stereotype.Component;

import com.myorg.business.entitys.Entidade;
import com.myorg.infrastructure.Specification;

/**
 * Nessa classe, deve ser implementada todas as especifições do objeto para entrada do mesmo no negocio.
 * @version 1.0 29 Mar 2001
 * @author Udinei
 *
 */
@Component("cadastrarEntidadeSpecification")
public class CadastrarEntidadeSpecification implements Specification<Entidade> {
    
	@Override
	public boolean isSatisfiedBy(Entidade obj) {
		boolean retorno = false;
		
		//o id objeto esta dentro das especificação de negocio
		if(obj.getName().equals("") || obj.getId() == 0){ 
			
			if(obj.getName().equals("")){ 
				
				retorno = false;
			}
		}
		
		return retorno;
	}

	
	

	
}

	

	


