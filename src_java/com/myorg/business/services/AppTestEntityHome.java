package com.myorg.business.services;

import java.util.ArrayList;

import com.myorg.business.repositorys.AppTestDAO;



public class AppTestEntityHome {
        
	public AppTestDAO appTest;
	
	public ArrayList getList(int firstResult, int maxResults) throws Exception {
		try {
			return this.appTest.getList(firstResult, maxResults);
			
		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
	}
	
	
}
