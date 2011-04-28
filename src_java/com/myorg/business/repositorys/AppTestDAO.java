package com.myorg.business.repositorys;

import java.util.ArrayList;
import java.util.List;

import com.myorg.business.entitys.AppTest;


public interface AppTestDAO {
	
	void remove(AppTest appTest);

	AppTest save(AppTest appTest);

	AppTest findById(AppTest appTest) throws Exception;

	AppTest findById(Integer appTest) throws Exception;
	
	List<AppTest> getList();
			
	ArrayList getList(int firstResult, int maxResults);
	
	List<AppTest> getSearch(AppTest appTest) throws Exception;
	
	List<AppTest> listPaginacao(int firstResult, int maxResults);

	Integer getTotalRegistros()  throws Exception;
	
}