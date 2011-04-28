package com.myorg.business.entitys; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;









@Entity
public class AppTest { 
	
	@Id
	@GeneratedValue
	private Integer id;
	private String dsDescricao;
		

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDsDescricao() {
		return dsDescricao;
	}
	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}
}
