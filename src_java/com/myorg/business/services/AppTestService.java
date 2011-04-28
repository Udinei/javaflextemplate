package com.myorg.business.services;

import java.util.List;

import com.myorg.business.entitys.AppTest;


public interface AppTestService {
	
	void remove(AppTest appTest) throws Exception;

	AppTest save(AppTest appTest) throws Exception;

	AppTest findById(AppTest appTest) throws Exception;

	List<AppTest> getList() throws Exception;
	
	List<AppTest> getSearch(AppTest appTest) throws Exception;
	
	List<AppTest> listPaginacao(int firstResult, int maxResults ) throws Exception;

	String getTotalRegistros() throws Exception;
}