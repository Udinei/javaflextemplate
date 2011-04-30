package com.myorg.business.entitys;


import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


/**
 * Introdução:
 * Essa classe segue o padrão JavaBean (POJO) estrutura de classe com construtor default sem argumentos e métodos que seguem o padrão de getters e setters para seus atributos.
 * Termo foi inventado por Martin Fowler, Rebecca Parsons e Josh MacKenzie em Setembro de 2000
 *@author Udinei
 *@since 23-03-2011 23:19
 */
@Entity
public class Entidade  implements Serializable {

	
	public Entidade() {}
	public int id;
	public String name;
			
	@SequenceGenerator(name = "generator", sequenceName = "seq_entidade", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Entidade other = (Entidade) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
