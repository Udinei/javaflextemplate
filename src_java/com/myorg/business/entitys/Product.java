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
 * Este padrão é baseado na idéia de que quanto mais simples o projeto, melhor. O termo foi inventado por Martin Fowler, Rebecca Parsons e Josh MacKenzie em Setembro de 2000
 *@author Udinei
 *@since 23-03-2011 23:19
 */
@Entity
public class Product implements Serializable {

	
	public Product() {}
	
	private int id;
	private String name;

	
	@SequenceGenerator(name = "generator", sequenceName = "seq_product", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	public int getId() {
		return id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Product other = (Product) obj;
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
